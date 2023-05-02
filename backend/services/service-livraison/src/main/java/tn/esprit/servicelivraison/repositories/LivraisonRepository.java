package tn.esprit.servicelivraison.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.servicelivraison.entities.Livraison;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

}
