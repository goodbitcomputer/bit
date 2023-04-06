package com.bit.carechart.mapper;


import com.bit.carechart.model.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<MemberDTO> selectAll();
}
