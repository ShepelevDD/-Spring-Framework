package com.example.studreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class StudregApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new PrintStream(System.out, true, "UTF-8"));
		System.setErr(new PrintStream(System.err, true, "UTF-8"));
		SpringApplication.run(StudregApplication.class, args);
	}

}
