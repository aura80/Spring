package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("getClients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        clientService.updateClient(clientId, name, email);
    }


    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteClientById(clientId);
    }
}
