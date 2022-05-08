package com.dar.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends ElasticsearchRepository<ClientEntity, String> {
    ClientEntity getClientEntityByClientId(String clientId);

    List<ClientEntity> getClientEntitiesBy();
}
