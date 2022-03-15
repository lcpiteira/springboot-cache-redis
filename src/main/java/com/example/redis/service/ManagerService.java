package com.example.redis.service;

import com.example.redis.models.Manager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ManagerService {

    Map<Integer, Manager> managersDb = new HashMap<>();

    public ManagerService() {
        managersDb.put(1,
                Manager
                        .builder()
                        .name("João ALberto")
                        .id(1)
                        .profile("GESTOR")
                        .build());
    }

    @Cacheable(value = "managerService", key = "#id", unless = "#result == null")
    public Manager getManagerFromName(Integer id){
        return getManager(id);

    }

    public Manager getManager(Integer id){

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return managersDb.get(id) != null ? managersDb.get(id) : null;
    }

    public Manager addManager(Manager manager){
        managersDb.put(manager.getId(),manager);
        return manager;
    }

}
