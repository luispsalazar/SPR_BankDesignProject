package javaBankDesignProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

	SpringApplication.run(MainApplication.class, args);

	System.out.println("Welcome to Banking app");
    }
}