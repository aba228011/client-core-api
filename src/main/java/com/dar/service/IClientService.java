package com.dar.service;

import com.dar.model.ClientRequest;
import com.dar.model.ClientResponse;

import java.util.List;

public interface IClientService {
    List<ClientResponse> getAllClients();

    ClientResponse createClient(ClientRequest clientRequest, String clientId);

    ClientResponse getClientById(String clientId);
}