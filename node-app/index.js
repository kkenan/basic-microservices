const express = require('express');
const app = express();
const port = 8081;

app.get('/node/api/v1/result', (req, res) => 
  res.json({ data: 'Hello world from node app' }));

app.listen(port, () => console.log(`Node app listening on port ${port}!`))