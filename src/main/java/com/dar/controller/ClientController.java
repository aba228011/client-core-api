package com.dar.controller;

import com.dar.model.ClientRequest;
import com.dar.model.ClientResponse;
import com.dar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String checkController() {
        return "client-core-api is working at " + env.getProperty("local.server.port");
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientResponse createClient(@Valid @RequestBody ClientRequest clientRequest, @RequestParam String clientId) {
        // clientId для того чтобы можно было найти информацию через айди в post-office-api getPaymentDetailsInfo методе
        return clientService.createClient(clientRequest, clientId);
    }

    @GetMapping
    public ClientResponse getClientById(@RequestParam String clientId) {
        return clientService.getClientById(clientId);
    }
}