package com.example.webserver.mapper;

import com.example.webserver.dto.QuestionDTO;
import com.example.webserver.dto.SubjectDTO;
import com.example.webserver.dto.UserDTO;
import com.example.webserver.model.Question;
import com.example.webserver.model.Subject;
import com.example.webserver.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T13:08:51+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public void updateQuestionFromDto(QuestionDTO dto, Question entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getQuestion() != null ) {
            entity.setQuestion( dto.getQuestion() );
        }
        if ( dto.getAnswer() != null ) {
            entity.setAnswer( dto.getAnswer() );
        }
        if ( dto.getIdSub() != null ) {
            entity.setIdSub( dto.getIdSub() );
        }
    }

    @Override
    public void updateSubjectFromDto(SubjectDTO dto, Subject entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getIdUser() != null ) {
            entity.setIdUser( dto.getIdUser() );
        }
    }

    @Override
    public void updateUserFromDto(UserDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUserName() != null ) {
            entity.setUserName( dto.getUserName() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getMatchingPassword() != null ) {
            entity.setMatchingPassword( dto.getMatchingPassword() );
        }
    }
}
