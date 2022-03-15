package com.example.redis.service;

import com.example.redis.models.Client;
import com.example.redis.models.LarContext;
import com.example.redis.models.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LarContextService {

    private final ClientService clientService;
    private final ManagerService managerService;

    public LarContext getLarContext(Integer managerId, Integer clientId){

        Client clientFromName = clientService.getClientFromName(clientId);
        Manager managerFromName = managerService.getManagerFromName(managerId);

        return
                LarContext
                    .builder()
                        .manager(managerFromName)
                        .client(clientFromName)
                        .build();

    }

}
