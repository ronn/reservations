package com.ronn.reservations.domain.service;

import com.ronn.reservations.domain.model.Client;
import com.ronn.reservations.domain.repo.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepo;

    public List<Client> getAll(){
        return clientRepo.findAll();
    }

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client save(Client client){
        return clientRepo.save(client);
    }

    public void delete(String dni){
        clientRepo.findClientByDni(dni)
                .ifPresent(clientRepo::delete);
    }

    public Optional<Client> findByDni(String dni){
        return clientRepo.findClientByDni(dni);
    }
}