package com.example.webserver.dto;

import com.example.webserver.model.User;
import lombok.Getter;

@Getter
public class UserDTO {

    private Long id;

    private String userName;

    private String password;

    private String matchingPassword;


    public UserDTO(Long id, String userName,String password,  String matchingPassword) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public UserDTO(User c) {
        this.id = c.getId();
        this.userName = c.getUserName();
        this.password = c.getPassword();
        this.matchingPassword = c.getMatchingPassword();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User convertToEntity() {
        User c = new User();
        c.setId(id);
        c.setUserName(userName);
        c.setPassword(password);
        c.setMatchingPassword(matchingPassword);
        return c;
    }
}
