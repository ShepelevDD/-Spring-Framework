package org.example;

import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = context.getBean(ContactManager.class);
        while(true){
            System.out.println("Выберите операцию:");
            System.out.println("0 - Завершить работу приложения");
            System.out.println("1 - Вывести имеющиеся контакты");
            System.out.println("2 - Добавить новый контакт");
            System.out.println("3 - Удалить контакт по email");
            System.out.println("4 - Сохранить имеющиеся контакты");
            int option = scanner.nextInt();
            boolean shouldBreak = false;
            switch (option){
                case 0:
                    System.out.println("Работа приложения завершена!");
                    shouldBreak = true;
                    break;
                case 1:
                    manager.printAllContacts();
                    break;
                case 2:
                    manager.addContact();
                    break;
                case 3:
                    manager.deleteContactByEmail();
                    break;
                case 4:
                    manager.saveContacts();
                    break;
                default:
                    System.out.println("Введено неверное значение");
            }
            if (shouldBreak) break;
        }

    }
}
