import * as React from "react";
import * as ReactDOM from "react-dom";
import MyTake from "./components/MyTake";
import config from "./components/MyTake/config";

let app: HTMLElement = document.getElementById("app");
// let initJson;
// if (app.hasAttribute('data-init')) {
//     initJson = JSON.parse(app.getAttribute('data-init'));
// } else {
//     initJson = config.initialState;
// }
// let initStateParsed = Raw.deserialize(initJson, { terse: true });

const Root = (
	<MyTake />
);

ReactDOM.render(Root, app)
