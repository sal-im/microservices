package tn.esprit.servicereclamation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.servicereclamation.entities.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
