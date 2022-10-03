package com.example.webserver.repository;

import com.example.webserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT id From public.user " +
            "WHERE user_name IN(:userName) " +
            "AND   password IN(:password);",nativeQuery = true)
    List<String> searchUserByLoginAndPassword(@Param("userName") String userName,
                                              @Param("password") String password);


    User findUserByUserName(String userName);


}
