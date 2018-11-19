// module.exports make the content inside visible to application
module.exports = function(app, http,passport,logger) {
	app.get('/',function(req, res) {
		
        res.sendfile('./views/index.html');
           
});
};
