package com.dar.service;

import com.dar.model.ClientModel;

import java.util.List;

public interface IClientService {
    List<ClientModel> getAllClients();

    ClientModel getClientById(String clientId);
}