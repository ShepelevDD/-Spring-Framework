package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

@Component
public class ContactManager {


    private HashMap<String, Contact> contacts = new HashMap<>();

    @Value("${app.save.path}")
    private String path;

    public ContactManager(HashMap<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name;
            String phoneNumber;
            String email;

            while (true) {
                System.out.println("Введите фио контакта");
                name = scanner.nextLine();
                if (nameCheck(name)) break;
            }

            while (true) {
                System.out.println("Введите номер телефона контакта");
                phoneNumber = scanner.nextLine();
                if (phoneNumberCheck(phoneNumber)) break;
            }

            while (true) {
                System.out.println("Введите email контакта");
                email = scanner.nextLine();
                if (emailCheck(email)) break;
            }

            contacts.put(email, new Contact(name, phoneNumber, email));
            System.out.println("Контакт успешно добавлен!");
            break;
        }
    }

    public void deleteContactByEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;
        while (true) {
            System.out.println("Введите email для удаления конакта");
            email = scanner.nextLine();
            if (!contacts.keySet().contains(email)) {
                System.out.println("Контакт с введенным email отсутствует. Попробуйте ещё раз");
                continue;
            }
            break;
        }
        contacts.remove(email);
        System.out.println("Контакт успешно удалён!");
    }

    public void printAllContacts(){
        if (contacts.size() == 0){
            System.out.println("Контакты отсутствуют");
            return;
        }
        System.out.println("Список имеющихся контактов:");
        for (Contact contact: contacts.values()){
            System.out.println(contact.getFullName() + " | " + contact.getPhoneNumber() + " | " + contact.getEmail());
        }
    }

    public void saveContacts() throws IOException {
        FileWriter writer = new FileWriter(path, false);
        for (Contact contact: contacts.values()){
            writer.write(contact.getFullName() + ";" + contact.getPhoneNumber() + ";" + contact.getEmail() + "\n");
        }
        writer.close();
        System.out.println("Контакты успешно были сохраненны по пути: " + path);
    }

    private boolean nameCheck(String name){
        if (name.length() == 0) {
            System.out.println("Вы ввели пустую строку! Попробуйте еще раз");
            return false;
        }
        return true;
    }

    private boolean phoneNumberCheck(String phoneNumber){
        if (phoneNumber.length() == 0) {
            System.out.println("Вы ввели пустую строку! Попробуйте еще раз");
            return false;
        }
        return true;
    }

    private boolean emailCheck(String email){
        if (email.length() == 0) {
            System.out.println("Вы ввели пустую строку! Попробуйте еще раз");
            return false;
        }
        return true;
    }

}
