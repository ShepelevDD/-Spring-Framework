package com.example.studreg.event;

import com.example.studreg.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class StudentAdded extends ApplicationEvent {
    private final Student student;
    public StudentAdded(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
