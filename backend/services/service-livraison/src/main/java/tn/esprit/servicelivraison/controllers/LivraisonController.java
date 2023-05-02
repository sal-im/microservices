package tn.esprit.servicelivraison.controllers;

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

import tn.esprit.servicelivraison.entities.Livraison;
import tn.esprit.servicelivraison.services.ILivraisonService;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

	@Autowired
	ILivraisonService livraisonService;

	@GetMapping("/list")
	public List<Livraison> getAllLivraisons() {
		return livraisonService.getAllLivraisons();
	}

	@GetMapping("/getById/{id}")
	public Livraison getLivraisonById(@PathVariable Long id) {
		return livraisonService.getLivraisonById(id);
	}

	@PostMapping("/add")
	public Livraison addLivraison(@RequestBody Livraison livraison) {
		return livraisonService.addLivraison(livraison);
	}

	@PutMapping("/update")
	public Livraison updateLivraison(@RequestBody Livraison livraison) {
		return livraisonService.updateLivraison(livraison);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteLivraisonById(@PathVariable Long id) {
		return livraisonService.deleteLivraisonById(id);
	}

}
