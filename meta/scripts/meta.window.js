"use strict";
exports.__esModule = true;
var body = document.body;
addNavEvents();
setTimeout(function () { addScrollEvent(); }, 500);
function addScrollEvent() {
    var dHeader = document.getElementsByClassName("d-header")[0];
    function handleScroll(e) {
        if (dHeader) {
            if (window.scrollY >= 200) {
                body.classList.add("docked");
            }
            else {
                body.classList.remove("docked");
            }
        }
    }
    window.addEventListener("scroll", handleScroll);
}
function addNavEvents() {
    var navToggle = document.getElementsByClassName("header__nav-toggle")[0];
    var navMenu = document.getElementsByClassName("nav")[0];
    function mainNavEvent(e) {
        if (!e.defaultPrevented) {
            toggleMainNav();
        }
        e.preventDefault();
    }
    function bodyEvent(e) {
        if (body.classList.contains("fade--mt") && !e.defaultPrevented) {
            if (e.srcElement &&
                !e.srcElement.classList.contains("header__nav--icon")) {
                if (!e.srcElement.classList.contains("nav__link") &&
                    !e.srcElement.classList.contains("nav__link-text")) {
                    toggleMainNav();
                    e.preventDefault();
                }
            }
        }
    }
    function toggleMainNav() {
        if (navMenu) {
            if (navMenu.classList.contains("collapse")) {
                navMenu.classList.remove("collapse");
            }
            else {
                navMenu.classList.add("collapse");
            }
        }
        if (body.classList.contains("fade--mt")) {
            body.classList.remove("fade--mt");
        }
        else {
            body.classList.add("fade--mt");
        }
    }
    if (navToggle) {
        navToggle.addEventListener("click", mainNavEvent);
    }
    body.addEventListener("click", bodyEvent);
    body.addEventListener("touchstart", bodyEvent);
}