import * as React from "react";
import { mount, ReactWrapper } from "enzyme";
import { Foundation } from "../../java2ts/Foundation";
import { FoundationNode } from "../../utils/functions";
import {} from "jest";

import TimelinePreview from "./TimelinePreview";

const onDocumentSetClick = jest.fn();
const onVideoSetClick = jest.fn();

interface MockWindow extends Window {
  scrollTo: jest.Mock<{}> & typeof window.scrollTo;
}

function getMockWindow() {
  window.scrollTo = jest.fn();
  return window as MockWindow;
}

let mockWindow = getMockWindow();

describe("Foundation Document", () => {
  let wrapper: ReactWrapper;
  const offset = 399;
  const highlightedRange: [number, number] = [327, 500];
  const viewRange: [number, number] = [327, 500];
  const factLink: Foundation.FactLink = {
    fact: {
      title: "Amendment 13",
      primaryDate: "1865-12-06",
      primaryDateKind: "ratified",
      kind: "document"
    },
    hash: "o_dRqrNJ62wzlgLilTrLxkHqGmvAS9qTpa4z4pjyFqA="
  };

  const nodes: FoundationNode[] = [
    {
      component: "p",
      innerHTML: [
        "Section 1. Neither slavery nor involuntary servitude, except as a punishment for crime whereof the party shall have been duly convicted, shall exist within the United States, or any place subject to their jurisdiction."
      ],
      offset: 0
    },
    {
      component: "p",
      innerHTML: [
        "Section 2. Congress shall have power to enforce this article by appropriate legislation."
      ],
      offset: 218
    }
  ];

  const setFactHandlers = {
    handleDocumentSetClick: onDocumentSetClick,
    handleVideoSetClick: onVideoSetClick
  };
  const ranges = {
    highlightedRange: highlightedRange,
    viewRange: viewRange
  };

  beforeAll(() => {
    wrapper = mount(
      <TimelinePreview
        factLink={factLink}
        nodes={nodes}
        setFactHandlers={setFactHandlers}
        ranges={ranges}
        offset={offset}
      />
    );
  });

  test("Document renders", () => {
    expect(wrapper.find(TimelinePreview).length).toBe(1);
  });

  test("Scrolling header renders", () => {
    wrapper.setState({ headerHidden: false });
    expect(wrapper.find(".document__header--visible").length).toBe(1);

    wrapper.setState({ headerHidden: true });
    expect(wrapper.find(".document__header--visible").length).toBe(0);
  });

  test("Fixed header renders", () => {
    wrapper.setState({ headerHidden: false });
    expect(wrapper.find(".document__header--fixed").length).toBe(0);

    wrapper.setState({ headerHidden: true });
    expect(wrapper.find(".document__header--fixed").length).toBe(1);
  });

  test("Heading text renders properly", () => {
    expect(wrapper.find(".document__heading").first().text()).toBe(
      "Amendment 13"
    );
  });

  test("Header buttons render", () => {
    // Header button is sibling along with h2.document__heading

    // On initial render, there is 1 button
    expect(
      wrapper.find(".document__header").first().childAt(0).children().length
    ).toBe(2);

    // When the button, "Clear Selection" is clicked, it is hidden and a paragraph is shown instead
    wrapper
      .find(".document__header")
      .first()
      .childAt(0)
      .childAt(1)
      .childAt(0)
      .simulate("click");
    expect(
      wrapper.find(".document__header").first().childAt(0).children().length
    ).toBe(2);

    // When some more text is highlighted, the "Clear Selection" button is shown again
    wrapper.setState({ textIsHighlighted: true });
    expect(
      wrapper.find(".document__header").first().childAt(0).children().length
    ).toBe(2);
  });

  test("Set text click works for initial highlight", () => {
    wrapper.find(".editor__block--overlay").simulate("click");
    expect(onDocumentSetClick).toHaveBeenCalled();
  });

  test("Amendment text renders", () => {
    expect(wrapper.find(".document__text").length).toBe(2);
  });

  test("Initial highlights render", () => {
    expect(wrapper.find(".editor__block--overlay").length).toBe(1);
  });

  test("Clear button works", () => {
    wrapper.setState({ textIsHighlighted: true });
    wrapper
      .find(".document__header")
      .children()
      .at(0)
      .children()
      .at(1)
      .children()
      .at(0)
      .simulate("click");
    expect(wrapper.state("textIsHighlighted")).toBe(false);
  });

  // test("Window autoscrolls", () => {
  //   // expect(mockWindow.scrollTo).toHaveBeenCalledWith(0, 6967);
  //   // in Document.tsx, getStartRangeOffsetTop should return 7167,
  //   // but this returns 0 while testing.
  //   // Can't figure out how to mock out that function.
  //   // Good info here, but it's not enough https://stackoverflow.com/questions/39633919/cannot-mock-a-module-with-jest-and-test-function-calls?rq=1

  //   expect(mockWindow.scrollTo).toHaveBeenCalled();
  // });

  /**
	 * TODO: 
	 *   - Add the following test cases:
	 *     + Some text is highlighted by user
	 * 	   + Set text click works for user highlights
	 *   - Fix test cases:
	 *     + Window autoscrolls (See comments inside test block)
	 */
});
