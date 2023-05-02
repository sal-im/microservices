package tn.esprit.servicereclamation.services;

import java.util.List;

import tn.esprit.servicereclamation.entities.Reclamation;

/**
 *
 * @author SALIM AMARA _ salim.amara@esprit.tn 2ALINFO3S
 */
public interface IReclamationService {

	
	public List<Reclamation> getAllReclamations();
	
	public Reclamation getReclamationById(Long id);
	
	public Reclamation addReclamation(Reclamation reclamation);
	
	public Reclamation updateReclamation(Reclamation reclamation);
	
	public Boolean deleteReclamationById(Long recId);
}
