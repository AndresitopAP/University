const routes = require('./src/routes');
const express = require('express');
const app = express();

app.disable('x-powered-by');
app.use(express.json({ 'limit': '5mb' }));
app.use(express.urlencoded({ 'extended': true }));

app.all('*', (req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Request-Headers', '*');
  res.header('Access-Control-Allow-Credentials', true);
  res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');

  next();
});

app.use('/home', routes);

module.exports = app;

//app.use(express.static(path.join(__dirname, "scripts")));

//settings
//app.set('port', process.env.PORT || 3000);
//app.set('json spaces', 2);

//midelwares
//app.use(morgan('dev'));
//app.use(express.urlencoded({extended: false}));
//app.use(express.json());

//routes
//app.use(require('./src/routes/index.js'))