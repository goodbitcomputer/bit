package com.bit.carechart.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime entryDate;
}
