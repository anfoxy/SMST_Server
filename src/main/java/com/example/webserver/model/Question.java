package com.example.webserver.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Data
@Table(name = "question", schema = "public")
@Getter
@Setter
public class Question {

    @Id
    @Column(name = "id_q", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String question;

    @Column
    private String answer;

    @ManyToOne
    @JoinColumn(name = "id_sub")
    private Subject idSub;

    public Question() {
    }


}
