package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientById = clientRepository.findClientById(client.getId());

        if (clientById.isPresent()) {
            throw new IllegalStateException("id already exists");
        }

        clientRepository.save(client);
    }

    public void deleteClientById(Long clientId) {
        boolean existsById = clientRepository.existsById(clientId);
        if (!existsById) {
            throw new IllegalStateException("student with id: " + clientId + " doesn't exist");
        }

        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(Long clientId, String name, String email) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalStateException("client with id: " + clientId + " doesn't exist"));

        if (name != null && name.length() > 0 && !Objects.equals(client.getName(), name)) {
            client.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(client.getEmail(), email)) {
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);

            if (clientOptional.isPresent()) {
                throw new IllegalStateException("email already exists");
            }

            client.setEmail(email);
        }
    }
}
