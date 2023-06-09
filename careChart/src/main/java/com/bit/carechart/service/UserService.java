package com.bit.carechart.service;


import com.bit.carechart.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final String NAMESPACE = "mapper.UserMapper";
    private SqlSession session;
    private BCryptPasswordEncoder passwordEncoder; // password는 데이터베이스에 인코딩되어 저장되어야한다. (시큐리티에서 막음)

    @Autowired
    public UserService(SqlSession session) {
        this.session = session;
    }


    public boolean validate(String username) {
        return session.selectOne(NAMESPACE + ".validate", username) == null;
    }


    public UserDTO selectOne(int id) {
        return session.selectOne(NAMESPACE + ".selectOne", id);
    }
    public List<UserDTO> selectAll() {
        return session.selectList(NAMESPACE + ".selectAll");
    }


    public void delete(int id) {
        session.delete(NAMESPACE + ".delete", id);
    }


}

