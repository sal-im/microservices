package tn.esprit.microserviceswallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import tn.esprit.microserviceswallet.entities.UserEntity;
import tn.esprit.microserviceswallet.entities.WalletEntity;
import tn.esprit.microserviceswallet.repositories.WalletRepository;

import java.util.List;

/**
 * Implementation of the IWalletService interface that provides CRUD operations for Wallet entities.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@Service
public class WalletServiceImpl implements IWalletService {
    /**
     * The WalletRepository object used for accessing Wallet data in the database.
     * This object is automatically initialized and injected into the WalletController
     * by Spring's dependency injection framework using the @Autowired annotation.
     */
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WebClient webClient;

    /**
     * Retrieves a list of all Wallets in the database.
     *
     * @return A list of Wallet entities.
     */
    @Override
    public List<WalletEntity> getAllWallet() {
        return walletRepository.findAll();
    }

    /**
     * Retrieves a Wallet entity from the database based on its ID.
     *
     * @param id The ID of the Wallet to retrieve.
     * @return The Wallet entity with the specified ID, or null if no such Wallets exists.
     */
    @Override
    public WalletEntity getWalletById(Long id) {
        return walletRepository.findById(id).orElse(null);
    }


    /**
     * Creates a new Wallet entity in the database.
     *
     * @param walletEntity The Wallet entity to create.
     * @return The created Wallet entity, with a hashed password.
     */
    @Override
    public WalletEntity createWallet(WalletEntity walletEntity) {
        walletEntity.setTotal(walletEntity.getTotal());
//        UserEntity user = restTemplate.getForObject("http://localhost:8000/users/list/" + walletEntity.getUserId(), UserEntity.class);
        UserEntity user = webClient.get()
                .uri("http://gatewayapi:8000/users/list/" + walletEntity.getUserId())
                .retrieve()
                .bodyToMono(UserEntity.class)
                .block();
        if (user != null) {
            walletEntity.setUserId(user.getId());
        } else {
            throw new IllegalArgumentException("user with id "+walletEntity.getUserId()+" not found");
        }
        walletEntity.setUserCode(user.getCode());
        walletEntity.setDebit(0);
        walletEntity.setCredit(0);
        return walletRepository.save(walletEntity);
    }

    /**
     * Updates an existing Wallet entity in the database.
     *
     * @param id         The ID of the Wallet to update.
     * @param walletEntity The updated Wallet entity.
     * @return The updated Wallet entity
     */
    @Override
    public WalletEntity updateWallet(Long id, WalletEntity walletEntity) {
        WalletEntity existingWalletEntity = walletRepository.findById(id).orElse(null);
        if (existingWalletEntity != null) {
            existingWalletEntity.setTotal(walletEntity.getTotal());
            UserEntity user = webClient.get()
                    .uri("http://gatewayapi:8000/users/list/" + walletEntity.getUserId())
                    .retrieve()
                    .bodyToMono(UserEntity.class)
                    .block();
            if (user != null) {
                existingWalletEntity.setUserId(user.getId());
            } else {
                throw new IllegalArgumentException("user with id "+walletEntity.getUserId()+" not found");
            }
            existingWalletEntity.setUserCode(user.getCode());
            existingWalletEntity.setCredit(walletEntity.getCredit());
            existingWalletEntity.setDebit(walletEntity.getDebit());
            return walletRepository.save(existingWalletEntity);
        }
        return null;
    }

    /**
     * Deletes a Wallet entity from the database based on its ID.
     *
     * @param id The ID of the Wallet to delete.
     */
    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

}
