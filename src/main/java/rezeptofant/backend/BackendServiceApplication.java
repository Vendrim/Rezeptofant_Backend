package rezeptofant.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BackendServiceApplication {

	public static void main(String[] args) {
		log.info("Starting server...");
		SpringApplication.run(BackendServiceApplication.class, args);
	}

}
