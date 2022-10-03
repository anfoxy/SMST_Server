package com.example.webserver.controller;

import com.example.webserver.exception.ResourceNotFoundException;
import com.example.webserver.model.Question;
import com.example.webserver.model.Subject;
import com.example.webserver.respons.DeleteResponse;
import com.example.webserver.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @GetMapping("/subject")
    public List<Subject> getAllSubject() {
        return subjectService.findAll();
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(subjectService.findById(id));
    }

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody Subject subject){
        return  subjectService.save(subject);
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<DeleteResponse> deleteSubject(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        subjectService.delete(id);
        return ResponseEntity.ok(new DeleteResponse("Subject with id:"+id+" deleted"));
    }

    @PatchMapping(value = "/subject/{id}")
    public ResponseEntity<Subject> patchSubject(@PathVariable Long id, @RequestBody Subject req) throws ResourceNotFoundException {
        return ResponseEntity.ok(subjectService.updateSubject(req,id));
    }

    @PutMapping("/subject/{id}")
    public ResponseEntity<Subject> putSubject(@PathVariable Long id,@RequestBody Subject req) throws ResourceNotFoundException {
        return ResponseEntity.ok(subjectService.putMet(id,req));
    }

}















