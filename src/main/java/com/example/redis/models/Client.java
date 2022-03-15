package com.example.redis.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private Integer phone;
}
