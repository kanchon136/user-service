package userservice.com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(UserServiceApplication.class, args);
		
		SpringApplication application = new SpringApplication(UserServiceApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		log.info("============User_Service is running..===========");
		
	}

}
