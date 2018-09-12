package ar.com.pangolines.FRANBackend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FranBackendApplication implements ApplicationRunner{
	private static final Logger logger = LogManager.getLogger(FranBackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FranBackendApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
        logger.info("************* PANGOLINES NINJAS *************");
	}
	
	
}
