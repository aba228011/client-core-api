package com.dar.service;

import com.dar.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService implements IClientService {

    private static final HashMap<String, ClientModel> clientHashMap = new HashMap<>();

    static {
        ClientModel clientModel1 = new ClientModel(
                "client1",
                "Antonio Banderas",
                "antonio@mail.ru");
        ClientModel clientModel2 = new ClientModel(
                UUID.randomUUID().toString(),
                "Lady Gaga",
                "grammy22@gmail.com");
        ClientModel clientModel3 = new ClientModel(
                "client3",
                "Tom Jerry",
                "tom_jerry@yandex.ru");

        clientHashMap.put(clientModel1.getClientId(), clientModel1);
        clientHashMap.put(clientModel2.getClientId(), clientModel2);
        clientHashMap.put(clientModel3.getClientId(), clientModel3);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientHashMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientHashMap.get(clientId);
    }
}
