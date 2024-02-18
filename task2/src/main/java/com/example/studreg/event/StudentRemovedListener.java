package com.example.studreg.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentRemovedListener {

    @EventListener
    public void listen(StudentRemoved sr){
        System.out.println("Контакт студента был удален. Идентификатор: " + sr.getId());
    }

}
