/**
 * Module dependencies.
 */
var express = require('express'), fs = require('fs'), http = require('http'), path = require('path'),passport = require('passport'),SamlStrategy = require('passport-saml').Strategy;

var app = express();

app.use(function(req, res, next) {
	  res.header("Access-Control-Allow-Origin", "*");
	  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	  next();
	});

app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'html');
app.use(app.router);
app.use(express.static(path.join(__dirname, 'resources')));

// development only
if ('development' == app.get('env')) {
	app.use(express.errorHandler());
}

require('./routes/routes')(app, http);

http.createServer(app).listen(app.get('port'), function() {
	console.log('Express server listening on port ' + app.get('port'));
	});
