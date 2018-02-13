package cl.usach.dminute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cl.usach.dminute")
public class DMinuteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMinuteMsApplication.class, args);
	}
}
