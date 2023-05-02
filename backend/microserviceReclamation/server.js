const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();

// ...

const reclamationController = require('./controllers/reclamation.controller');

app.post('/reclamations', reclamationController.create);

app.get('/reclamations', reclamationController.getAll);

app.get('/reclamations/:reclam_id', reclamationController.getById);

app.put('/reclamations/:reclam_id', reclamationController.update);

app.delete('/reclamations/:reclam_id', reclamationController.delete);