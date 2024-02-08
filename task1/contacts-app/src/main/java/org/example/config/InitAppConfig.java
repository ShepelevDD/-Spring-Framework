package org.example.config;

import org.example.Contact;
import org.example.ContactManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
@Profile("init")
@PropertySource("classpath:application-init.properties")
public class InitAppConfig {

    @Value("${app.init.path}")
    private String path;

    @Bean
    public ContactManager contactManager(){
        HashMap<String, Contact> storage = new HashMap<>();
        List<String> lines = new ArrayList<>();
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                lines.add(strLine);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

        for (String line: lines){
            String[] tokens = line.split(";");
            storage.put(tokens[2], new Contact(tokens[0], tokens[1], tokens[2]));
        }
        System.out.println("Хранилище было инициализовано!");
        return new ContactManager(storage);

    }
}

