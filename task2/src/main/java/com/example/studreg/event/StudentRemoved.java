package com.example.studreg.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
public class StudentRemoved extends ApplicationEvent {
    private final UUID id;
    public StudentRemoved(Object source, UUID id) {
        super(source);
        this.id = id;
    }
}
