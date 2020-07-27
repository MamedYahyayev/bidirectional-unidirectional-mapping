package az.maqa.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BidirectionalUnidirectionalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BidirectionalUnidirectionalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BidirectionalUnidirectionalApplication.class);
	}

}
