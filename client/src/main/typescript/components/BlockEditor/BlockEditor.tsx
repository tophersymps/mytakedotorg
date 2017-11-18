import * as React from "react";
import * as keycode from "keycode";
import YouTube from "react-youtube";
import DocumentTextNodeList from "../DocumentTextNodeList";
import CaptionedVideo from "../Video";
import { getDocumentFactTitle, getVideoFact } from "../../utils/databaseAPI";
import {
  getNodeArray,
  getHighlightedNodes,
  FoundationNode,
  FoundationNodeProps
} from "../../utils/functions";
import {
  ParagraphBlock,
  DocumentBlock,
  VideoBlock,
  TakeBlock,
  TakeDocument
} from "../../server/api";

/////////////////
// React model //
/////////////////
interface WritingEventHandlers {
  handleDelete: (idx: number) => void;
  handleEnterPress: (isTitle?: boolean) => void;
  handleFocus: (idx: number) => void;
  handleChange?: (idx: number, value: string) => void;
}
interface ParagraphBlockProps {
  idx: number;
  active: boolean;
  block: ParagraphBlock;
  eventHandlers?: WritingEventHandlers;
}
interface ParagraphBlockState {
  style: any;
}
interface ReadingEventHandlers {
  onDocumentClick: (
    excerptId: string,
    offset: number,
    highlightedRange: [number, number],
    viewRange: [number, number]
  ) => void;
}
function isWriteOnly(
  eventHandlers: WritingEventHandlers | ReadingEventHandlers | undefined
): eventHandlers is WritingEventHandlers {
  if (eventHandlers) {
    return (eventHandlers as WritingEventHandlers).handleDelete !== undefined;
  } else {
    return false;
  }
}
interface DocumentBlockProps {
  idx: number;
  active: boolean;
  block: DocumentBlock;
  eventHandlers: WritingEventHandlers | ReadingEventHandlers;
}
interface DocumentBlockState {
  documentNodes: FoundationNode[];
}
interface VideoBlockProps {
  idx: number;
  active: boolean;
  block: VideoBlock;
  eventHandlers?: WritingEventHandlers;
}
interface VideoBlockState {}

class Paragraph extends React.Component<
  ParagraphBlockProps,
  ParagraphBlockState
> {
  private text: HTMLTextAreaElement | HTMLParagraphElement;
  private paragraph: HTMLParagraphElement;
  constructor(props: ParagraphBlockProps) {
    super(props);

    this.state = {
      style: {}
    };
  }
  handleBlur = () => {
    if (isWriteOnly(this.props.eventHandlers) && !this.props.block.text) {
      // Paragraph is about to lose focus. If empty, should be removed.
      this.props.eventHandlers.handleDelete(this.props.idx);
    }
  };
  handleKeyDown = (ev: React.KeyboardEvent<HTMLTextAreaElement>) => {
    switch (ev.keyCode) {
      case keycode("enter"):
        ev.preventDefault();
        if (isWriteOnly(this.props.eventHandlers)) {
          this.props.eventHandlers.handleEnterPress();
        }
        break;
      case keycode("backspace") || keycode("delete"):
        if (isWriteOnly(this.props.eventHandlers) && !this.props.block.text) {
          this.props.eventHandlers.handleDelete(this.props.idx);
        }
        break;
      default:
        break;
    }
  };
  handleChange = (ev: React.ChangeEvent<HTMLTextAreaElement>) => {
    if (
      isWriteOnly(this.props.eventHandlers) &&
      this.props.eventHandlers.handleChange
    ) {
      this.props.eventHandlers.handleChange(this.props.idx, ev.target.value);
    }
  };
  handleClick = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    }
  };
  handleFocus = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    }
  };
  handleKeyUp = (ev: React.KeyboardEvent<HTMLTextAreaElement>) => {
    this.resetHeight();
  };
  resetHeight = () => {
    let content: string = this.props.block.text;
    content = content.replace(/\n/g, "<br />");
    this.paragraph.innerHTML = content + "<br />";
    let height = this.paragraph.clientHeight;
    this.setState({
      style: { height: height }
    });
  };
  componentDidMount() {
    this.resetHeight();
    if (this.props.active) {
      this.text.focus();
    }
  }
  componentDidUpdate() {
    if (this.props.active) {
      this.text.focus();
    }
  }
  componentWillReceiveProps(nextProps: ParagraphBlockProps) {
    if (this.props.block.text !== nextProps.block.text) {
      this.resetHeight();
    }
  }
  render() {
    let classes = "editor__paragraph";
    return (
      <div className="editor__text-container">
        {isWriteOnly(this.props.eventHandlers)
          ? <textarea
              className={classes}
              onBlur={this.handleBlur}
              onChange={this.handleChange}
              onClick={this.handleClick}
              onFocus={this.handleFocus}
              onKeyDown={this.handleKeyDown}
              onKeyUp={this.handleKeyUp}
              placeholder={
                this.props.idx === 0 ? "Use your voice here." : "..."
              }
              value={this.props.block.text}
              style={this.state.style}
              ref={(text: HTMLTextAreaElement) => (this.text = text)}
            />
          : <p
              className={classes}
              style={this.state.style}
              ref={(text: HTMLParagraphElement) => (this.text = text)}
            >
              {this.props.block.text}
            </p>}
        <div className="editor__paragraph-height-div">
          <p
            ref={(paragraph: HTMLParagraphElement) =>
              (this.paragraph = paragraph)}
          >
            <br />
          </p>
        </div>
      </div>
    );
  }
}

class Document extends React.Component<DocumentBlockProps, DocumentBlockState> {
  private div: HTMLDivElement;
  constructor(props: DocumentBlockProps) {
    super(props);

    this.state = {
      documentNodes: getNodeArray(props.block.excerptId)
    };
  }
  blocksAreEqual(b1: DocumentBlock, b2: DocumentBlock): boolean {
    if (b1.excerptId !== b2.excerptId) {
      return false;
    }
    if (b1.highlightedRange[0] !== b2.highlightedRange[0]) {
      return false;
    }
    if (b1.highlightedRange[1] !== b2.highlightedRange[1]) {
      return false;
    }
    return true;
  }
  getTitle = () => {
    return getDocumentFactTitle(this.props.block.excerptId);
  };
  handleClick = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    } else {
      this.props.eventHandlers.onDocumentClick(
        this.props.block.excerptId,
        this.div.getBoundingClientRect().top,
        this.props.block.highlightedRange,
        this.props.block.viewRange
      );
    }
  };
  handleFocus = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    }
  };
  handleKeyDown = (ev: React.KeyboardEvent<HTMLDivElement>) => {
    switch (ev.keyCode) {
      case keycode("enter"):
        if (isWriteOnly(this.props.eventHandlers)) {
          this.props.eventHandlers.handleEnterPress();
        }
        break;
      case keycode("backspace") || keycode("delete"):
        if (isWriteOnly(this.props.eventHandlers)) {
          this.props.eventHandlers.handleDelete(this.props.idx);
        }
        break;
      default:
        break;
    }
  };
  componentWillReceiveProps(nextProps: DocumentBlockProps) {
    if (!this.blocksAreEqual(this.props.block, nextProps.block)) {
      this.setState({
        documentNodes: getNodeArray(nextProps.block.excerptId)
      });
    }
  }
  render() {
    const { props } = this;
    let highlightedNodes = getHighlightedNodes(
      [...this.state.documentNodes],
      props.block.highlightedRange,
      props.block.viewRange
    );

    let classes = "editor__document editor__document--base";
    if (isWriteOnly(this.props.eventHandlers)) {
      classes += " editor__document--no-hover";
    }
    const innerContent = (
      <div>
        <h2 className="editor__document-title">
          {this.getTitle()}
        </h2>
        <DocumentTextNodeList documentNodes={highlightedNodes} />
      </div>
    );

    if (isWriteOnly(this.props.eventHandlers)) {
      return (
        <div
          tabIndex={0}
          className="editor__document editor__document--base editor__document--focus"
          onClick={this.handleClick}
          onFocus={this.handleFocus}
          onKeyDown={this.handleKeyDown}
          ref={(div: HTMLDivElement) => (this.div = div)}
        >
          {innerContent}
        </div>
      );
    } else {
      return (
        <div
          className="editor__document editor__document--base editor__document--hover"
          onClick={this.handleClick}
          ref={(div: HTMLDivElement) => (this.div = div)}
        >
          {innerContent}
        </div>
      );
    }
  }
}

class Video extends React.Component<VideoBlockProps, VideoBlockState> {
  constructor(props: VideoBlockProps) {
    super(props);
  }
  handleClick = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    }
  };
  handleFocus = () => {
    if (isWriteOnly(this.props.eventHandlers)) {
      this.props.eventHandlers.handleFocus(this.props.idx);
    }
  };
  handleKeyDown = (ev: React.KeyboardEvent<HTMLDivElement>) => {
    switch (ev.keyCode) {
      case keycode("enter"):
        if (isWriteOnly(this.props.eventHandlers)) {
          this.props.eventHandlers.handleEnterPress();
        }
        break;
      case keycode("backspace") || keycode("delete"):
        if (isWriteOnly(this.props.eventHandlers)) {
          this.props.eventHandlers.handleDelete(this.props.idx);
        }
        break;
      default:
        break;
    }
  };
  handleSetClick = (range: [number, number]): void => {
    throw "TODO";
  };
  handleVideoEnd = (event: any) => {
    event.target.stopVideo();
  };
  render() {
    const { props } = this;

    let classes = "editor__video-container";

    return (
      <div
        tabIndex={0}
        className={classes}
        onClick={this.handleClick}
        onFocus={this.handleFocus}
        onKeyDown={this.handleKeyDown}
      >
        <CaptionedVideo
          onSetClick={this.handleSetClick}
          video={getVideoFact(this.props.block.videoId)}
          timeRange={this.props.block.range}
        />
      </div>
    );
  }
}

interface BlockContainerProps {
  block: TakeBlock;
  index: number;
  eventHandlers: WritingEventHandlers | ReadingEventHandlers;
  active: boolean;
}

class BlockContainer extends React.Component<BlockContainerProps, {}> {
  constructor(props: BlockContainerProps) {
    super(props);
  }
  render() {
    let inner;
    const { props } = this;
    switch (props.block.kind) {
      case "paragraph":
        if (isWriteOnly(props.eventHandlers)) {
          inner = (
            <Paragraph
              block={props.block}
              idx={props.index}
              active={props.active}
              eventHandlers={props.eventHandlers}
            />
          );
        } else {
          inner = (
            <Paragraph
              block={props.block}
              idx={props.index}
              active={props.active}
            />
          );
        }
        break;
      case "document":
        inner = (
          <Document
            block={props.block}
            idx={props.index}
            active={props.active}
            eventHandlers={props.eventHandlers}
          />
        );
        break;
      case "video":
        if (isWriteOnly(props.eventHandlers)) {
          inner = (
            <Video
              block={props.block as VideoBlock}
              idx={props.index}
              active={props.active}
              eventHandlers={props.eventHandlers}
            />
          );
        } else {
          inner = (
            <Video
              block={props.block as VideoBlock}
              idx={props.index}
              active={props.active}
            />
          );
        }
        break;
    }

    return (
      <div className="editor__block editor__block--base">
        {inner}
      </div>
    );
  }
}

interface BlockEditorProps {
  takeDocument: TakeDocument;
  active?: number;
  eventHandlers: WritingEventHandlers | ReadingEventHandlers;
}

interface BlockEditorState {
  style: any;
}

class BlockEditor extends React.Component<BlockEditorProps, BlockEditorState> {
  private text: HTMLTextAreaElement | HTMLHeadingElement;
  private div: HTMLDivElement;
  constructor(props: BlockEditorProps) {
    super(props);

    this.state = {
      style: {}
    };
  }
  handleChange = (ev: React.ChangeEvent<HTMLTextAreaElement>) => {
    if (
      isWriteOnly(this.props.eventHandlers) &&
      this.props.eventHandlers.handleChange
    ) {
      this.props.eventHandlers.handleChange(-1, ev.target.value);
    }
  };
  handleKeyDown = (ev: React.KeyboardEvent<HTMLTextAreaElement>) => {
    if (isWriteOnly(this.props.eventHandlers)) {
      if (ev.keyCode === keycode("enter")) {
        ev.preventDefault();
        this.props.eventHandlers.handleEnterPress(true);
      }
    }
  };
  handleKeyUp = (ev: React.KeyboardEvent<HTMLTextAreaElement>) => {
    this.resetHeight();
  };
  resetHeight = () => {
    let content: string = this.props.takeDocument.title;
    content = content.replace(/\n/g, "<br />");
    this.div.innerHTML = content + "<br />";
    let height = this.div.clientHeight;
    this.setState({
      style: { height: height }
    });
  };
  componentDidMount() {
    this.resetHeight();
    if (this.props.active === -1) {
      this.text.focus();
    }
  }
  componentDidUpdate() {
    if (this.props.active === -1) {
      this.text.focus();
    }
  }
  render() {
    const { props } = this;
    return (
      <div className="editor__wrapper">
        <div className="editor">
          <div className="editor__inner">
            <div className="editor__text-container">
              {!isWriteOnly(props.eventHandlers)
                ? <h1
                    className="editor__title"
                    style={this.state.style}
                    ref={(text: HTMLHeadingElement) => (this.text = text)}
                  >
                    {props.takeDocument.title}
                  </h1>
                : <textarea
                    className="editor__title"
                    onChange={this.handleChange}
                    onKeyDown={this.handleKeyDown}
                    onKeyUp={this.handleKeyUp}
                    placeholder="Title"
                    value={props.takeDocument.title}
                    style={this.state.style}
                    ref={(text: HTMLTextAreaElement) => (this.text = text)}
                  />}
              <div
                className="editor__title-height-div"
                ref={(div: HTMLDivElement) => (this.div = div)}
              />
            </div>
            <div className="editor__block-list">
              {props.takeDocument.blocks.map((block, idx) => {
                if (!isWriteOnly(props.eventHandlers)) {
                  const readingEventHandlers: ReadingEventHandlers = {
                    onDocumentClick: props.eventHandlers.onDocumentClick
                  };
                  return (
                    <BlockContainer
                      key={idx.toString()}
                      index={idx}
                      block={(Object as any).assign({}, block)}
                      eventHandlers={readingEventHandlers}
                      active={idx === props.active}
                    />
                  );
                } else {
                  const writingEventHandlers: WritingEventHandlers = {
                    handleChange: props.eventHandlers.handleChange,
                    handleDelete: props.eventHandlers.handleDelete,
                    handleEnterPress: props.eventHandlers.handleEnterPress,
                    handleFocus: props.eventHandlers.handleFocus
                  };
                  return (
                    <BlockContainer
                      key={idx.toString()}
                      index={idx}
                      block={(Object as any).assign({}, block)}
                      eventHandlers={writingEventHandlers}
                      active={idx === props.active}
                    />
                  );
                }
              })}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default BlockEditor;