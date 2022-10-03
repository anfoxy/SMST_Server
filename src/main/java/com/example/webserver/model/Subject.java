package com.example.webserver.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subject", schema = "public")
@Getter
@Setter
public class Subject {

    @Id
    @Column(name = "id_sub",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_us")
    private User idUser;

    public Subject() {}

    public Subject(Long id, String name, User idUser) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
    }

    public Subject(String name, User idUser) {
        this.name = name;
        this.idUser = idUser;
    }
}
