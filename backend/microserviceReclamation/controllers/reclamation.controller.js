const Reclamation = require('../models/reclamation.model');

exports.create = function(req, res) {
  const reclam = new Reclamation();
  reclam.nom = req.body.nom;
  reclam.email = req.body.email;
  reclam.message = req.body.message;

  reclam.save(function(err) {
    if (err)
      res.send(err);
    res.json({ message: 'Réclamation créée avec succès !' });
  });
};

exports.getAll = function(req, res) {
  Reclamation.find(function(err, reclams) {
    if (err)
      res.send(err);
    res.json(reclams);
  });
};

exports.getById = function(req, res) {
  Reclamation.findById(req.params.reclam_id, function(err, reclam) {
    if (err)
      res.send(err);
    res.json(reclam);
  });
};

exports.update = function(req, res) {
  Reclamation.findById(req.params.reclam_id, function(err, reclam) {
    if (err)
      res.send(err);

    reclam.nom = req.body.nom;
    reclam.email = req.body.email;
    reclam.message = req.body.message;

    reclam.save(function(err) {
      if (err)
        res.send(err);
      res.json({ message: 'Réclamation mise à jour avec succès !' });
    });
  });
};

exports.delete = function(req, res) {
  Reclamation.remove({
    _id: req.params.reclam_id
  }, function(err, reclam) {
    if (err)
      res.send(err);
    res.json({ message: 'Réclamation supprimée avec succès !' });
  });
};
