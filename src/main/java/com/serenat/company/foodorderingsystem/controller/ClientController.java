package com.serenat.company.foodorderingsystem.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenat.company.foodorderingsystem.model.Client;
import com.serenat.company.foodorderingsystem.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getCllientById(@PathVariable Long clientId) {
        Client client = clientService.findClientById(clientId);
        return ResponseEntity.ok(client); 
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long clientId) {
        clientService.deleteClientById(clientId);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/{clientId}/favorite-stores/{storeId}")
    public ResponseEntity<Void> addFavoriteStores(@PathVariable Long storeId, @PathVariable Long clientId) {
        clientService.addFavoriteStores(storeId, clientId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{clientId}/favorite-stores/{storeId}")
    public ResponseEntity<Void> removeFromFavoriteStores(@PathVariable Long storeId, @PathVariable Long clientId) {
        clientService.removeFromFavoriteStores(storeId, clientId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{clientId}/favorite-store")
    public ResponseEntity<HashSet<Long>> getFavoriteStores(@PathVariable Long clientId) {
        HashSet<Long> favoriteStoresIds = clientService.getFavoriteStoresIds(clientId);
        return ResponseEntity.ok(favoriteStoresIds);
    }


}
