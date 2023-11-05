const app = require('./app');
const morgan = require('morgan');
const port = 3000;

//starting the server
app.listen(port, () => {
  console.log(`Server on port ${port}`);
});