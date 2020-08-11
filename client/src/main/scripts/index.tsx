/*
 * MyTake.org website and tooling.
 * Copyright (C) 2017-2020 MyTake.org, Inc.
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
import * as React from "react";
import * as ReactDOM from "react-dom";
import { TakeDocument } from "./components/BlockEditor";
import BlockReader from "./components/BlockReader";
import BlockWriter, {
  InitialBlockWriterState,
  initialState,
} from "./components/BlockWriter";
import { Card } from "./components/FeedList";
import FoundationView from "./components/FoundationView";
import Home from "./components/Home";
import VideoResultsLoader from "./components/search/VideoResultsLoader";
import SearchBar from "./components/SearchBar";
import UserNav from "./components/UserNav";
import { alertErr } from "./utils/functions";
import { windowUtils } from "./utils/window";

windowUtils.init();

interface HomeArgs {
  type: "home";
  cards: Card[];
}

interface ShowTakeArgs {
  type: "showtake";
  takeDocument: TakeDocument;
  takeId: number;
}

interface FoundationArgs {
  type: "foundation";
}

interface NewTakeArgs {
  type: "new-take";
  blockWriterState?: InitialBlockWriterState;
}

interface SearchArgs {
  type: "search";
  searchTerm: string;
}

type MyTakePage =
  | HomeArgs
  | ShowTakeArgs
  | FoundationArgs
  | NewTakeArgs
  | SearchArgs;

declare global {
  interface Window {
    mytake?: MyTakePage;
  }
}

const app: HTMLElement | null = document.getElementById("app");
if (app) {
  let Root;
  if (typeof window.mytake != "undefined") {
    switch (window.mytake.type) {
      case "foundation":
        Root = (
          <FoundationView
            path={window.location.pathname}
            search={window.location.search}
          />
        );
        break;
      case "new-take":
        let initJson: InitialBlockWriterState;
        let windowState = window.mytake.blockWriterState;
        if (typeof windowState != "undefined") {
          if (
            windowState.takeDocument.blocks === null ||
            windowState.takeDocument.blocks.length === 0
          ) {
            windowState = {
              ...windowState,
              takeDocument: {
                ...windowState.takeDocument,
                blocks: [...initialState.takeDocument.blocks],
              },
            };
          }
          initJson = windowState;
        } else {
          initJson = (Object as any).assign({}, initialState);
        }

        Root = (
          <BlockWriter initState={initJson} hashUrl={window.location.hash} />
        );
        break;
      case "home":
        Root = <Home />;
        break;
      case "showtake":
        Root = (
          <BlockReader
            initState={window.mytake.takeDocument}
            takeId={window.mytake.takeId}
          />
        );
        break;
      case "search":
        Root = <VideoResultsLoader searchQuery={window.mytake.searchTerm} />;
        break;
      default:
        alertErr("index: unknown argument structure");
        throw "Unknown argument structure";
    }
  } else {
    alertErr("index: window.mytake is undefined");
    throw "window.mytake is undefined";
  }
  ReactDOM.render(Root, app);
}

const searchBarContainer: HTMLElement | null = document.getElementById(
  "searchbar"
);
if (!isHomePage(window.mytake)) {
  let searchTerm = "";
  if (isSearchPage(window.mytake)) {
    searchTerm = window.mytake.searchTerm;
  }
  ReactDOM.render(<SearchBar searchTerm={searchTerm} />, searchBarContainer);
}

const userNavContainer: HTMLElement | null = document.getElementById("usernav");
if (userNavContainer) {
  ReactDOM.render(<UserNav />, userNavContainer);
} else {
  alertErr("index: couldn't find div#usernav");
  throw "Couldn't find div#usernav";
}

function isHomePage(page?: MyTakePage): page is HomeArgs {
  return (page as HomeArgs).type === "home";
}

function isSearchPage(page?: MyTakePage): page is SearchArgs {
  return (page as SearchArgs).type === "search";
}
