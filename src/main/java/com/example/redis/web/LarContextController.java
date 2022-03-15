package com.example.redis.web;

import com.example.redis.models.Client;
import com.example.redis.models.LarContext;
import com.example.redis.models.Manager;
import com.example.redis.service.ClientService;
import com.example.redis.service.LarContextService;
import com.example.redis.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LarContextController {
    private final LarContextService larContextService;
    private final ManagerService managerService;
    private final ClientService clientService;

    @GetMapping(value = "/lar-context/{managerId}/{clientId}")
    public LarContext getLarContext(@PathVariable Integer managerId, @PathVariable Integer clientId){
        return larContextService.getLarContext(managerId, clientId);
    }

    @PostMapping(value = "/managers")
    public Manager addManager(@RequestBody Manager manager){
        return managerService.addManager(manager);
    }

    @PostMapping(value = "/clients")
    public Client addClients(@RequestBody Client client){
        return clientService.addClient(client);
    }
}
