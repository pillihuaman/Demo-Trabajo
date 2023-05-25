package pe.gob.contraloria.bspscgestorpei;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BsTempGestionpeiApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-5"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BsTempGestionpeiApplication.class, args);
	}
}