/*
 * MyTake.org website and tooling.
 * Copyright (C) 2020 MyTake.org, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact us at team@mytake.org
 */
import { launch } from "puppeteer";

function pathToTemplate(): string {
  const TARGET = "node/build/dist-client/socialEmbed.html";
  const SRC = "node/src/main/scripts";
  const DIST = "node/build/dist";
  if (__dirname.endsWith(DIST)) {
    return __dirname.slice(0, -DIST.length) + TARGET;
  } else if (__dirname.endsWith(SRC)) {
    return __dirname.slice(0, -SRC.length) + TARGET;
  } else {
    throw "Unhandled directory " + __dirname;
  }
}

export class RenderQueue {
  static async render(socialRison: string): Promise<Buffer> {
    const browser = await launch({
      args: ["--no-sandbox", "--disable-web-security"],
    });
    try {
      const page = await browser.newPage();
      try {
        await page.setViewport({
          width: 600,
          height: 314, // aspect ratio of 1.91
          deviceScaleFactor: 2,
        });
        await page.goto("file://" + pathToTemplate());
        await page.evaluate((arg) => {
          (window as any).render(arg);
        }, socialRison);

        const blocker = new Blocker<string>();
        page.on("console", (msg) => {
          blocker.set(msg.text());
        });
        const consoleMsg = await blocker.get();
        if (consoleMsg !== socialRison) {
          throw `Expected ${socialRison} but was ${consoleMsg}`;
        }
        return await page.screenshot({
          encoding: "binary",
          type: "png",
          fullPage: true,
        });
      } finally {
        await page.close();
      }
    } finally {
      await browser.close();
    }
  }
}

class Blocker<T> {
  promise: Promise<T>;
  resolver: (arg: T) => void;

  constructor() {
    this.promise = new Promise((resolve, reject) => {
      this.resolver = resolve;
    });
  }

  set(arg: T): void {
    this.resolver(arg);
  }

  get(): Promise<T> {
    return this.promise;
  }
}
