package com.example.webserver.controller;

import com.example.webserver.exception.ResourceNotFoundException;
import com.example.webserver.model.Question;
import com.example.webserver.respons.DeleteResponse;
import com.example.webserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/question")
    public List<Question> getAllQuestion() {
        return questionService.findAll();
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(questionService.findById(id));
    }

    @PostMapping("/question")
    public Question createQuestion(@RequestBody Question question){
        return  questionService.save(question);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<DeleteResponse> deleteQuestion(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        questionService.delete(id);
        return ResponseEntity.ok(new DeleteResponse("Question with id:"+id+" deleted"));
    }
    @PatchMapping(value = "/question/{id}")
    public ResponseEntity<Question> patchUser(@PathVariable Long id, @RequestBody Question question) throws ResourceNotFoundException {
        return ResponseEntity.ok(questionService.updateQuestion(question,id));
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<Question> putUser(@PathVariable Long id,@RequestBody Question req) throws ResourceNotFoundException {
        return ResponseEntity.ok(questionService.putMet(id,req));
    }

}














