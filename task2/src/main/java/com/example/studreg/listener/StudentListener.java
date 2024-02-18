package com.example.studreg.listener;

import com.example.studreg.Student;
import com.example.studreg.StudentManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Component
@ConditionalOnProperty("app.init.enabled")
@PropertySource("classpath:application.properties")
public class StudentListener {

    StudentManager studentManager;
    @Value("${app.init.path}")
    private String path;
    public StudentListener(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Map<UUID, Student> students = new HashMap<>();
        List<String> lines = new ArrayList<>();
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                lines.add(strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

        for (String line: lines) {
            UUID id = UUID.randomUUID();
            String[] tokens = line.split(" ");
            students.put(id, new Student(id, tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }

        studentManager.setStudents(students);
        System.out.println("Students initialized");
    }

}
