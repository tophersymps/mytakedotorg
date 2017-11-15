import * as React from "react";
import * as ReactDOM from "react-dom";
import BlockWriter, { config } from "./components/BlockWriter";
import Foundation from "./components/Foundation";
import Fact from "./components/Fact";
import { getFact, validators } from "./utils/functions";
import { isDocument, isVideo } from "./utils/databaseData";

let app = document.getElementById("app");
let Root = <div />;

let url = window.location.pathname;
let route = url.split("/")[1];
let excerptId = url.split("/")[2];

if (route === "foundation" && !excerptId) {
  // mytake.org/foundation/ route
  Root = <Foundation />;
} else if (route === "foundation" && excerptId) {
  // e.g. mytake.org/foundation/bill-of-rights
  let hashes = window.location.hash.substring(1).split("&");
  let user = hashes[0].split("/")[1];
  let articleTitle = hashes[0].split("/")[2];
  let highlighedRange: [number, number] = [
    parseInt(hashes[1]),
    parseInt(hashes[2])
  ];
  let viewRange: [number, number] = [parseInt(hashes[3]), parseInt(hashes[4])];
  let scrollTop = parseInt(hashes[5]);

  // Validate all Props here
  if (
    validators.isValidUser(user) &&
    validators.isValidTitle(articleTitle) &&
    !isNaN(highlighedRange[0]) &&
    !isNaN(highlighedRange[1]) &&
    !isNaN(viewRange[0]) &&
    !isNaN(viewRange[1]) &&
    !isNaN(scrollTop)
  ) {
    Root = (
      <Fact
        articleTitle={articleTitle}
        articleUser={user}
        scrollTop={scrollTop}
        highlightedRange={highlighedRange}
        viewRange={viewRange}
        excerptId={excerptId}
      />
    );
  }
} else if (route === "new-take") {
  let initJson;
  if (app && app.hasAttribute("data-init")) {
    let data = app.getAttribute("data-init");
    if (data) {
      initJson = JSON.parse(data);
    } else {
      initJson = config.initialState;
    }
  } else if (window.location.hash) {
    // Expect hash URL to be like, #{FoundationType}&{highlightRangeStart}&{highlightRangeEnd}&{viewRangeStart}&{viewRangeEnd}&{URL of Take being read}
    // localhost:3000/new-take/#amendments&369&514&/samples/does-a-law-mean-what-it-says-or-what-it-meant/
    let hashes = window.location.hash.split("&");
    let excerptId = hashes[0].substring(1);
    let highlightedRange = [parseFloat(hashes[1]), parseFloat(hashes[2])];
    let viewRange = [parseFloat(hashes[3]), parseFloat(hashes[4])];

    let fact = getFact(excerptId);
    if (isDocument(fact)) {
      if (!isNaN(highlightedRange[0]) && !isNaN(highlightedRange[1])) {
        initJson = {
          takeDocument: {
            title: "",
            blocks: [
              {
                kind: "document",
                excerptId: excerptId,
                highlightedRange: highlightedRange,
                viewRange: viewRange
              },
              { kind: "paragraph", text: "" }
            ]
          },
          activeBlockIndex: -1
        };
      } else {
        initJson = config.initialState;
      }
    } else if (isVideo(fact)) {
      if (!isNaN(highlightedRange[0]) && !isNaN(highlightedRange[1])) {
        initJson = {
          takeDocument: {
            title: "",
            blocks: [
              { kind: "video", videoId: excerptId, range: highlightedRange },
              { kind: "paragraph", text: "" }
            ]
          },
          activeBlockIndex: -1
        };
      } else {
        initJson = config.initialState;
      }
    } else {
      initJson = config.initialState;
    }
  } else {
    initJson = config.initialState;
  }

  Root = <BlockWriter initState={initJson} />;
}

ReactDOM.render(Root, app);