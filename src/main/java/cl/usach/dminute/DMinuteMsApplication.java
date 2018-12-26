package cl.usach.dminute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication(scanBasePackages = "cl.usach.dminute")
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableAsync
@PropertySource(value = "classpath:application.yml", encoding = "ISO-8859-1")
public class DMinuteMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMinuteMsApplication.class, args);
	}
}