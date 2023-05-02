package tn.esprit.servicelivraison.services;

import java.util.List;

import tn.esprit.servicelivraison.entities.Livraison;

public interface ILivraisonService {

	public List<Livraison> getAllLivraisons();

	public Livraison getLivraisonById(Long id);

	public Livraison addLivraison(Livraison livraison);

	public Livraison updateLivraison(Livraison livraison);

	public Boolean deleteLivraisonById(Long recId);
}
