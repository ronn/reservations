package com.ronn.reservations.domain.service;

import com.ronn.reservations.domain.model.Client;
import com.ronn.reservations.domain.repo.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client save(Client client){
        return clientRepo.save(client);
    }

    public void delete(Client client){
        clientRepo.delete(client);
    }

    public Client findByDni(String dni){
        return clientRepo.findClientByDni(dni);
    }
}