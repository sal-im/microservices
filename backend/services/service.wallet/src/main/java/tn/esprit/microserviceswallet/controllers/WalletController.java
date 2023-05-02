package tn.esprit.microserviceswallet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.microserviceswallet.entities.WalletEntity;
import tn.esprit.microserviceswallet.services.IWalletService;

import java.util.List;

/**
 * This class represents the REST controller for managing wallet resources.
 *
 * @author Ahmed BAHRI _ bahri.ahmed@esprit.tn 2ALINFO3
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {
    /**
     * The service implementation for wallet management.
     */
    @Autowired
    private IWalletService iWalletService;

    /**
     * Returns a list of all wallet.
     *
     * @return A list of all wallet.
     */
    @GetMapping("/list")
    public List<WalletEntity> getAllWallet() {
        return iWalletService.getAllWallet();
    }

    /**
     * Returns the wallet with the specified ID.
     *
     * @param id The ID of the wallet to return.
     * @return The wallet with the specified ID, or null if no such wallet exists.
     */
    @GetMapping("/list/{id}")
    public WalletEntity getWalletById(@PathVariable Long id) {
        return iWalletService.getWalletById(id);
    }

    /**
     * Creates a new wallet.
     *
     * @param walletEntity The wallet to create.
     * @return The newly created wallet.
     */
    @PostMapping("/list/create")
    public WalletEntity createWallet(@RequestBody WalletEntity walletEntity) {
        if(walletEntity!=null){
            return iWalletService.createWallet(walletEntity);
        }
        return null;
    }

    /**
     * Updates the wallet with the specified ID.
     *
     * @param id         The ID of the wallet to update.
     * @param walletEntity The new wallet data.
     * @return The updated wallet, or null if no such wallet exists.
     */
    @PutMapping("/list/update/{id}")
    public WalletEntity updateWallet(@PathVariable Long id, @RequestBody WalletEntity walletEntity) {
        return iWalletService.updateWallet(id, walletEntity);
    }

    /**
     * Deletes the wallet with the specified ID.
     *
     * @param id The ID of the wallet to delete.
     */
    @DeleteMapping("/list/delete/{id}")
    public void deleteWallet(@PathVariable Long id) {
        iWalletService.deleteWallet(id);
    }

}
