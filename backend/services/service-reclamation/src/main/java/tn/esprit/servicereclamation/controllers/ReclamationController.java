package tn.esprit.servicereclamation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.servicereclamation.entities.Reclamation;
import tn.esprit.servicereclamation.services.IReclamationService;

/**
 * This class represents the REST controller for managing reclamation resources.
 *
 * @author SALIM AMARA _ salim.amara@esprit.tn 2ALINFO3
 */
@RestController
@RequestMapping("/reclamations")
public class ReclamationController {

	@Autowired
	IReclamationService reclamationService;

	@GetMapping("/list")
	public List<Reclamation> getAllReclamations() {
		return reclamationService.getAllReclamations();
	}

	@GetMapping("/getById/{id}")
	public Reclamation getReclamationById(@PathVariable Long id) {
		return reclamationService.getReclamationById(id);
	}

	@PostMapping("/add")
	public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.addReclamation(reclamation);
	}

	@PutMapping("/update")
	public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.updateReclamation(reclamation);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteReclamationById(@PathVariable Long id) {
		return reclamationService.deleteReclamationById(id);
	}

}
