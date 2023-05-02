package tn.esprit.servicelivraison.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.servicelivraison.entities.Livraison;
import tn.esprit.servicelivraison.repositories.LivraisonRepository;

@Service
public class LivarisonServiceImpl implements ILivraisonService{

	
	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Override
	public List<Livraison> getAllLivraisons() {
		return livraisonRepository.findAll();
	}

	@Override
	public Livraison getLivraisonById(Long id) {
		return livraisonRepository.findById(id).orElse(null);
	}

	@Override
	public Livraison addLivraison(Livraison livraison) {
		if (livraison !=null) {
			return livraisonRepository.save(livraison);
		}
		return null;
	}

	@Override
	public Livraison updateLivraison(Livraison livraison) {
		if (livraisonRepository.existsById(livraison.getId())) {
			Livraison toEdit = livraisonRepository.findById(livraison.getId()).get();
			toEdit.setAddress(livraison.getAddress());
			toEdit.setSecondAddress(livraison.getSecondAddress());
			toEdit.setOrderId(livraison.getOrderId());
			toEdit.setDeliveryAgentName(livraison.getDeliveryAgentName());
			toEdit.setDeliveryAgentNumber(livraison.getDeliveryAgentNumber());
			toEdit.setStatus(livraison.getStatus());
			return livraisonRepository.save(toEdit);
		}
		return null;
	}

	@Override
	public Boolean deleteLivraisonById(Long recId) {
		livraisonRepository.deleteById(recId);
		return !livraisonRepository.existsById(recId);
	}

}
