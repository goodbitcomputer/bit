package com.bit.careChart.mapper;

import com.bit.careChart.model.UserDTO;

import java.util.List;

public interface UserMapper {
    List<UserDTO> selectAll();

    UserDTO auth();

    UserDTO validate();
}
