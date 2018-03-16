import * as React from "react";
import * as ReactDOM from "react-dom";
import { alertErr } from "../utils/functions";

interface DropDownProps {
  children?: React.ReactNode;
  classModifier: string;
  disabled?: boolean;
  dropdownPosition: Position;
  toggleText: string | React.ReactNode;
}

type Position = "TL" | "TR" | "BL" | "BR";

interface DropDownState {
  dropDownIsOpen: boolean;
}

class DropDown extends React.Component<DropDownProps, DropDownState> {
  private div: HTMLDivElement;
  constructor(props: DropDownProps) {
    super(props);

    this.state = {
      dropDownIsOpen: false
    };
  }
  onMouseDown = (e: MouseEvent) => {
    const { disabled } = this.props;
    if (
      e.currentTarget &&
      (typeof disabled != "boolean" || disabled === false)
    ) {
      if (e.currentTarget === window && !e.defaultPrevented) {
        // This is the default handler, window was clicked, close dropDown
        this.setState({
          dropDownIsOpen: false
        });
        this.div.removeEventListener("mousedown", this.onMouseDown);
        window.removeEventListener("mousedown", this.onMouseDown);
      } else if (
        (e.currentTarget as HTMLElement).classList &&
        !(e.currentTarget as HTMLElement).classList.contains("dropdown")
      ) {
        // Something else was clicked, close dropDown
        this.setState({
          dropDownIsOpen: false
        });
        this.div.removeEventListener("mousedown", this.onMouseDown);
        window.removeEventListener("mousedown", this.onMouseDown);
      } else {
        // Something inside the share container was clicked, prevent default
        e.preventDefault();
      }
    }
  };
  toggleMenu = () => {
    const { disabled } = this.props;
    if (typeof disabled != "boolean" || disabled === false) {
      const dropDownIsOpen = this.state.dropDownIsOpen;
      if (!dropDownIsOpen) {
        this.div.addEventListener("mousedown", this.onMouseDown);
        window.addEventListener("mousedown", this.onMouseDown);
      } else {
        this.div.removeEventListener("mousedown", this.onMouseDown);
        window.removeEventListener("mousedown", this.onMouseDown);
      }
      this.setState({
        dropDownIsOpen: !dropDownIsOpen
      });
    }
  };
  componentWillUnmount() {
    this.div.removeEventListener("mousedown", this.onMouseDown);
    window.removeEventListener("mousedown", this.onMouseDown);
  }
  render() {
    let dropDownClassModifier;
    if (!this.state.dropDownIsOpen || this.props.disabled === true) {
      dropDownClassModifier = "hidden";
    } else {
      switch (this.props.dropdownPosition) {
        case "TL":
          dropDownClassModifier = "tl";
          break;
        case "TR":
          dropDownClassModifier = "tr";
          break;
        case "BL":
          dropDownClassModifier = "bl";
          break;
        case "BR":
          dropDownClassModifier = "br";
          break;
        default:
          const msg = "DropDown: Unknown position.";
          alertErr(msg);
          throw msg;
      }
    }

    return (
      <div
        className={"dropdown dropdown--" + this.props.classModifier}
        ref={(div: HTMLDivElement) => (this.div = div)}
      >
        <span
          className={
            "dropdown__toggle dropdown__toggle--" + this.props.classModifier
          }
          onClick={this.toggleMenu}
        >
          {this.props.toggleText}
        </span>
        <div
          className={
            "dropdown__dropdown dropdown__dropdown--" + dropDownClassModifier
          }
        >
          {this.props.children}
        </div>
      </div>
    );
  }
}

export default DropDown;
