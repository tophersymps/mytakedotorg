const express = require("express");
const logger = require("morgan");
const app = express();
import { Request, Response, NextFunction } from "express";

if (app.get("env") === "production") {
  app.set("trust proxy", 1); // trust first proxy
  app.use(logger("combined"));
} else {
  app.use(logger("dev"));
}

const images = require("./controllers/images");
app.use("/api/images", images);

app.get("/favicon.ico", (req: Request, res: Response) => {
  res.status(204);
});

declare global {
  interface Error {
    status?: number;
  }
}

// catch 404 and forward to error handler
app.use(function(req: Request, res: Response, next: NextFunction) {
  var err = new Error("Not Found");
  err.status = 404;
  next(err);
});

// development error handler will print stacktrace
if (app.get("env") === "development") {
  app.use(function(
    err: Error,
    req: Request,
    res: Response,
    next: NextFunction
  ) {
    res.status(err.status || 500);
    res.render("error", {
      message: err.message,
      error: err
    });
  });
}

// production error handler will not leak stacktrace
app.use(function(err: Error, req: Request, res: Response, next: NextFunction) {
  res.status(err.status || 500);
  res.render("error", {
    message: err.message,
    error: {}
  });
});

module.exports = app;
