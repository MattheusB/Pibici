var Pusher = require('pusher');
var express = require('express');
var pusher = new Pusher({
    app_id: "735390",
    key: "6649d90faeacdd56ad9b",
    secret: "2a8a9921b1222687b193",
    cluster: "us2"
        
});
var app = express();

app.post('/lancamentos', function(req, res){
  var release = req.body;
  pusher.trigger('release', 'new_release', release);
  res.json({success: 200});
});


module.exports = app;
