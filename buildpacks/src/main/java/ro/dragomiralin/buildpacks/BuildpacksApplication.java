package ro.dragomiralin.buildpacks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class BuildpacksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildpacksApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
				.GET("/", request -> ServerResponse.ok().body("Welcome to Buildpacks!"))
				.build();
	}

}
