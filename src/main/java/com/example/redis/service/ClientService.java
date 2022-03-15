package com.example.redis.service;

import com.example.redis.models.Client;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {
    Map<Integer, Client> clientsDb = new HashMap<>();

    public ClientService() {
        clientsDb.put(1,
                Client
                        .builder()
                        .name("Tony Martinez")
                        .id(1)
                        .address("Avenida Santos Silva")
                        .phone(960000000)
                        .build());
    }

    @Cacheable(value = "clientService", key = "#id", unless = "#result == null")
    public Client getClientFromName(Integer id){
        return getClient(id);

    }

    public Client getClient(Integer id){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return clientsDb.get(id) != null ? clientsDb.get(id) : null;
    }

    public Client addClient(Client client){
        clientsDb.put(client.getId(), client);
        return client;
    }



}
