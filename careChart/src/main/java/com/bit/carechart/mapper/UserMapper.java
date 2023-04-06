package com.bit.carechart.mapper;

import com.bit.carechart.model.UserDTO;

import java.util.List;

public interface UserMapper {
    List<UserDTO> selectAll();
}
