var Pusher = require('pusher');
var express = require('express');
var options = PusherOptions();
    options.setCluster(PUSHER_APP_CLUSTER);
var pusher = new Pusher({
    appId: "Indicator_App_Id",
    key: "Indicator_App_Key",
    secret: "Pusher_App_Secret"    
});

app.post('/lancamentos', function(req, res){
  var release = req.body;
  pusher.trigger('release', 'new_release', relsease);
  res.json({success: 200});
});


module.exports = app;
