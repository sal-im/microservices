/*const chai = require('chai');
const expect = chai.expect;
const Reclamation = require('../models/reclamation');
const reclamationController = require('../controllers/reclamationController');

describe('Reclamation model', () => {
    it('should be invalid if required fields are empty', (done) => {
      const reclam = new Reclamation();
  
      reclam.validate((err) => {
        expect(err.errors.type).to.exist;
        expect(err.errors.description).to.exist;
        done();
      });
    });
  
    it('should be valid if all fields are provided', (done) => {
      const reclam = new Reclamation({
        type: 'problem',
        description: 'Product did not arrive on time',
        status: 'pending'
      });
  
      reclam.validate((err) => {
        expect(err).to.be.null;
        done();
      });
    });
  });
  
  describe('Reclamation controller', () => {
    let reclamId;
  
    before((done) => {
      Reclamation.deleteMany({}, () => {
        done();
      });
    });
  
    it('should create a new reclamation', (done) => {
      const req = {
        body: {
          type: 'problem',
          description: 'Product did not arrive on time'
        }
      };
  
      const res = {
        json: (result) => {
          expect(result.type).to.equal('problem');
          expect(result.description).to.equal('Product did not arrive on time');
          reclamId = result._id;
          done();
        }
      };
  
      reclamationController.create(req, res);
    });
  
    it('should get all reclamations', (done) => {
      const req = {};
      const res = {
        json: (result) => {
          expect(result).to.be.an('array');
          expect(result).to.have.lengthOf(1);
          expect(result[0].type).to.equal('problem');
          expect(result[0].description).to.equal('Product did not arrive on time');
          done();
        }
      };
  
      reclamationController.getAll(req, res);
    });
  
    it('should get a reclamation by id', (done) => {
      const req = {
        params: { id: reclamId }
      };
  
      const res = {
        json: (result) => {
          expect(result.type).to.equal('problem');
          expect(result.description).to.equal('Product did not arrive on time');
          done();
        }
      };
  
      reclamationController.getById(req, res);
    });
  
    it('should update a reclamation', (done) => {
        const req = {
          params: { id: reclamId },
          body: {
            type: 'complaint',
            description: 'Product was damaged on delivery'
          }
        };

    const res = {
      json: (result) => {
        expect(result.type).to.equal('complaint');
        expect(result.description).to.equal('Product was damaged on delivery');
        done();
      }
    };

    reclamationController.update(req, res);
  });

  it('should delete a reclamation', (done) => {
    const req = {
      params: { id: reclamId }
    };

    const res = {
      json: (result) => {
        expect(result.type).to.equal('complaint');
        expect(result.description).to.equal('Product was damaged on delivery');

        Reclamation.findById(reclamId, (err, reclam) => {
          expect(reclam).to.be.null;
          done();
        });
      }
    };

    reclamationController.delete(req, res);
  });
});*/
