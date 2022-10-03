package com.example.webserver.dto;


import com.example.webserver.model.Subject;
import com.example.webserver.model.User;
import lombok.Getter;

@Getter
public class SubjectDTO {

    private Long id;

    private String name;

    private User idUser;



    public SubjectDTO(Long id, String name, User idUser) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
    }

    public SubjectDTO(Subject c) {
        this.id = c.getId();
        this.name = c.getName();
        this.idUser = c.getIdUser();

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject convertToEntity() {
        Subject c = new Subject();
        c.setId(id);
        c.setName(name);
        c.setIdUser(idUser);
        return c;
    }
}
