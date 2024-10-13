package com.serenat.company.foodorderingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
