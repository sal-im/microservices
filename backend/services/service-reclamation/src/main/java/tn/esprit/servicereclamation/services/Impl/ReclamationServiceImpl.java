package tn.esprit.servicereclamation.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.servicereclamation.entities.Reclamation;
import tn.esprit.servicereclamation.repositories.ReclamationRepository;
import tn.esprit.servicereclamation.services.IReclamationService;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	@Autowired
	ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> getAllReclamations() {
		return reclamationRepository.findAll();
	}

	@Override
	public Reclamation getReclamationById(Long id) {
		return reclamationRepository.findById(id).orElse(null);
	}

	@Override
	public Reclamation addReclamation(Reclamation reclamation) {
		if (reclamation != null) {
			return reclamationRepository.save(reclamation);
		}
		return null;
	}

	@Override
	public Reclamation updateReclamation(Reclamation reclamation) {
		if (reclamationRepository.existsById(reclamation.getId())) {
			Reclamation toEdit = reclamationRepository.findById(reclamation.getId()).orElse(null);
			toEdit.setTitle(reclamation.getTitle());
			toEdit.setDescription(reclamation.getDescription());
			toEdit.setStatus(reclamation.getStatus());
			return reclamationRepository.save(toEdit);
		}
		return null;
	}

	@Override
	public Boolean deleteReclamationById(Long recId) {
		reclamationRepository.deleteById(recId);
		return !reclamationRepository.existsById(recId);
	}

}
