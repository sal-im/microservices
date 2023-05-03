const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ProductSchema = new Schema({
  product_name: {
    type: String,
    required: true
  },
  price: {
    type: Number,
    required: true
  },
  category: {
    type: String,
    required: true
  },
   supplier: {
    type: String,
    required: true
  }
});

module.exports = mongoose.model('Product', ProductSchema);