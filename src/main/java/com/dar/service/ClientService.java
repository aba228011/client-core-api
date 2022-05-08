package com.dar.service;

import com.dar.model.ClientRequest;
import com.dar.model.ClientResponse;
import com.dar.repository.ClientEntity;
import com.dar.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();
    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.getClientEntitiesBy().stream()
                .map(post -> modelMapper.map(post, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest, String clientId) {
//        clientRequest.setClientId(UUID.randomUUID().toString());
        clientRequest.setClientId(clientId);

        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.getClientEntityByClientId(clientId);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }
}
