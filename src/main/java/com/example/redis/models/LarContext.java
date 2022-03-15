package com.example.redis.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LarContext implements Serializable {
    private Manager manager;
    private Client client;
}
