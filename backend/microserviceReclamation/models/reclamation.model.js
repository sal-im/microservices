const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ReclamationSchema = new Schema({
  nom: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true
  },
  message: {
    type: String,
    required: true
  }
});

module.exports = mongoose.model('Reclamation', ReclamationSchema);