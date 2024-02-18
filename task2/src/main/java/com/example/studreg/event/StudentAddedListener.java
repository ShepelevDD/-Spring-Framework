package com.example.studreg.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentAddedListener {

    @EventListener
    public void listen(StudentAdded studentAdded){
        System.out.println("Создан контакт! Вот информация:");
        System.out.println(studentAdded.getStudent().toString());
    }

}
