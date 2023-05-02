package com.example.order.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.order.entities.OrderEntity;

import java.util.Optional;
/**
 * This interface represents the repository for managing OrderEntity objects.
 * It extends the JpaRepository interface which provides basic CRUD operations
 * for the OrderEntity class and allows us to easily perform database operations.
 *
 * @author Mejda Sliman _ mejda.sliman@esprit.tn 2ALINFO3
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
   OrderEntity findByNameAndPrice(String name, String price);

}
