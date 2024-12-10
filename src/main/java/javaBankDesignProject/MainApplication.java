package javaBankDesignProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

	ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

	Object dataSource = context.getBean("dataSource");

	System.out.println("Welcome to Banking app");
    }
}