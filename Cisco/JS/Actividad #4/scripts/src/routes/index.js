const express = require("express")
const router = express.Router()
const path = require("path")
const fs = require("fs")
const http = require("http")

router.get("/", (req, res) => {
  res.setHeader("Content-Type", "text/javascript");
  //res.sendFile(path.join(__dirname, "../../../index.html"))
  fs.readFile(path.join(__dirname, "../../../index.html"), (err, data) => {
    if (err) {
      res.writeHead(404, { "Content-Type": "text/html" });
      return res.end("404 Not Found");
    }  
    res.writeHead(200, { "Content-Type": "text/html"});
    res.write(data);
    return res.end();
  });
});

/*
router.get("/test", (req, res) => {
  res.setHeader("Content-Type", "text/javascript");
  //res.sendFile(path.join(__dirname, "../../../index.html"))
  fs.readFile(path.join(__dirname, "../../../index.html"), (err, data) => {
    if (err) {
      res.writeHead(404, { "Content-Type": "text/html" });
      return res.end("404 Not Found");
    }  
    res.writeHead(200, { "Content-Type": "text/html"});
    res.write(data);
    return res.end();
  });
});
 
*/
//http.createServer((req, res) => {
//}).listen(8080);

module.exports = router