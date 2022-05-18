package com.example.laba11111.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;

}
