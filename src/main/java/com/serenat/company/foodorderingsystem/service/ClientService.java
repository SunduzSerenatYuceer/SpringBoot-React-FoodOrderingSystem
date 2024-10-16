package com.serenat.company.foodorderingsystem.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.serenat.company.foodorderingsystem.model.Client;
import com.serenat.company.foodorderingsystem.repository.ClientRepository;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;    


    public void createClient(Long userId) {

        Client newClient = new Client(userId);
        clientRepository.save(newClient);

    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(Long clientId) {

        Optional<Client> existingClient = clientRepository.findById(clientId);

        if(existingClient.isPresent()) {
            return existingClient.get();
        }
        else {
            throw new ResourceNotFoundException("Client not found with Id: " + clientId);
        }
    }

    public String deleteClientById(Long clientId) {
        
        Client client = findClientById(clientId);
        clientRepository.delete(client);
        return "Client is deleted successfully.";
    }

    public void addFavoriteStores(Long storeId, Long clientId) {
     
        Client client = clientRepository.findById(clientId).orElseThrow(() -> 
            new ResourceNotFoundException("Client not found with Id: " + clientId));

        client.addFavoriteStores(storeId);
        clientRepository.save(client);
    }

    public void removeFromFavoriteStores(Long storeId, Long clientId) {
        
        Client client = clientRepository.findById(clientId).orElseThrow(() -> 
            new ResourceNotFoundException("Client not found with Id: " + clientId));

        client.removeFromFavoriteStores(storeId);
        clientRepository.save(client);
    }

    public HashSet<Long> getFavoriteStoresIds(Long clientId) {

        Client client = clientRepository.findById(clientId).orElseThrow(() -> 
        new ResourceNotFoundException("Client not found with Id: " + clientId));

        return client.getFavoriteStoresIds();
    }



}
