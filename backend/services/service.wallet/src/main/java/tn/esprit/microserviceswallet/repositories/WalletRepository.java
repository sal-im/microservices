package tn.esprit.microserviceswallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.microserviceswallet.entities.WalletEntity;

/**
 * This interface represents the repository for managing UserEntity objects.
 * It extends the JpaRepository interface which provides basic CRUD operations
 * for the UserEntity class and allows us to easily perform database operations.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

}
