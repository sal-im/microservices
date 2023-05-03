const Product = require('../models/product.model');

exports.create = function(req, res) {
  const prod = new Product();
  
  prod.product_name= req.body.product_name;
  prod.price = req.body.price;
  prod.supplier = req.body.supplier;
  prod.category = req.body.category;

  prod.save().then((doc) =>{
    if (doc)
      res.send(doc);
   // res.json({ message: 'Produit créée avec succès !' });
  });
};

exports.getAll = function(req, res) {
  Product.find().then((prods) =>{
    res.json(prods);
  });
};

exports.getById = function(req, res) {
  console.log(req.params);

  Product.findById(req.params.prod_id).then((prod) =>{
    //if (prod)
    res.send(prod);
    
  }); 
};

exports.update = function(req, res) {
  Product.findById(req.params.prod_id).then(( prod) =>{
    //if (err)
      //res.send(err);

    prod.product_name = req.body.product_name;
    prod.price = req.body.price;
    prod.supplier = req.body.supplier;
    prod.category = req.body.category;


    prod.save().then((doc) =>{
      
      res.json({ message: 'Produit mise à jour avec succès !' });
    });
  });
};

exports.delete = function(req, res) {
  prod=Product.findById(req.params.prod_id)
  Product.deleteOne(prod).then(
    res.json({ message: 'Produit supprimée avec succès !' })
  )
};
