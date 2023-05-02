package tn.esprit.microserviceswallet.services;

import tn.esprit.microserviceswallet.entities.WalletEntity;

import java.util.List;

/**
 * Interface for the wallet Service, which provides operations for managing Wallet data.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
public interface IWalletService {
    /**
     * Retrieve a list of all Wallets in the system.
     *
     * @return A List of WalletEntity objects representing all Wallets in the system.
     */
    List<WalletEntity> getAllWallet();

    /**
     * Retrieve a Wallet with the specified ID.
     *
     * @param id The ID of the Wallet to retrieve.
     * @return A WalletEntity object representing the Wallet with the specified ID, or null if not found.
     */
    WalletEntity getWalletById(Long id);

    /**
     * Create a new Wallet with the specified data.
     *
     * @param walletEntity A walletEntity object containing the data for the new Wallet.
     * @return A walletEntity object representing the newly created Wallet.
     */
    WalletEntity createWallet(WalletEntity walletEntity);

    /**
     * Update an existing Wallet with the specified data.
     *
     * @param id         The ID of the Wallet to update.
     * @param walletEntity A WalletEntity object containing the updated data for the Wallet.
     * @return A WalletEntity object representing the updated Wallet, or null if the Wallet was not found.
     */
    WalletEntity updateWallet(Long id, WalletEntity walletEntity);

    /**
     * Delete a Wallet with the specified ID.
     *
     * @param id The ID of the Wallet to delete.
     */
    void deleteWallet(Long id);


}
