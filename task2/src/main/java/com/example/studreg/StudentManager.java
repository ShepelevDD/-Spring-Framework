package com.example.studreg;

import com.example.studreg.event.StudentAdded;
import com.example.studreg.event.StudentRemoved;
import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ShellComponent
@Data
public class StudentManager {
    private Map<UUID, Student> students = new HashMap<>();

    private ApplicationEventPublisher publisher;

    public StudentManager(Map<UUID, Student> students, ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    @ShellMethod(key = "a")
    public void addStudent(String firstName, String lastName, int age) {
        UUID id = UUID.randomUUID();
        students.put(id, new Student(id, firstName, lastName, age));
        publisher.publishEvent(new StudentAdded(this, students.get(id)));
    }

    @ShellMethod(key = "r")
    public void removeStudent(UUID id) {
        students.remove(id);
        publisher.publishEvent(new StudentRemoved(this, id));
    }

    @ShellMethod(key = "c")
    public void clearStudents(){
        students.clear();
    }

    @ShellMethod(key = "d")
    public void display() {
        if (students.size() == 0) {
            System.out.println("Список студентов пуст");
            return;
        }
        for (Student student : students.values()) {
            System.out.println(student.toString());
        }
    }
}
