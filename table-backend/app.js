var express = require('express');
var path = require('path');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var Pusher = require('pusher');

var releases = [];

var pusher = new Pusher({
  appId: "734187",
  key: "0856023995027ae6efe9",
  secret: "b78f095450e31757441f",
  encrypted: true,
  cluster: "us2"
});

var app = express();

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.post('/lancamentos', function(req, res){

  console.log(req.body)
  releases.push(req.body);
 
  console.log(releases)
  res.json({success: 200});
});

app.get('/lancamentos', function(req, res) {
  
  res.json(releases);



});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

//start server
app.listen(3001, function () {
  console.log('Node server running on port 3001');
});

module.exports = app;