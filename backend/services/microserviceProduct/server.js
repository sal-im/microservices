const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
/*const Eureka = require('eureka-js-client').Eureka;
eurekaConfig=require('./eureka-helper')
const eurekaClient = new Eureka(eurekaConfig);
eurekaClient.start();*/


const app = express();
app.listen(3000, function () {
  console.log('listening on 3000')
})
// Parses the text as url encoded data
app.use(bodyParser.urlencoded({ extended: true }));
 
// Parses the text as json
app.use(bodyParser.json());
console.log('Server Running...')
const MongoClient = require('mongodb').MongoClient;

const url = 'mongodb://mongodb:27017/mydb'; // replace 'mydb' with your database name

mongoose.connect(url,
  {
    useNewUrlParser: true,
    useUnifiedTopology: true
  }
);
console.log('Database Connected')
const productController = require('./controllers/product.controller');

app.post('/products', productController.create);

app.get('/products', productController.getAll);

app.get('/products/:prod_id', productController.getById);

app.put('/products/:prod_id', productController.update);

app.delete('/products/:prod_id', productController.delete);