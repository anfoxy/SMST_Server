package com.example.webserver.dto;

import com.example.webserver.model.Question;
import com.example.webserver.model.Subject;
import lombok.Getter;

@Getter
public class QuestionDTO {

    private Long id;

    private String question;

    private String answer;

    private Subject idSub;


    public QuestionDTO(Long id, String question, String answer, Subject idSub) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.idSub = idSub;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestionDTO(Question c) {
        this.id = c.getId();
        this.question = c.getQuestion();
        this.answer = c.getAnswer();
        this.idSub = c.getIdSub();
    }

    public Question convertToEntity() {
        Question c = new Question();
        c.setId(id);
        c.setQuestion(question);
        c.setAnswer(answer);
        c.setIdSub(idSub);
        return c;
    }
}
