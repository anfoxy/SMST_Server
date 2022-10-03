package com.example.webserver.repository;

import com.example.webserver.model.Subject;
import com.example.webserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {



}
