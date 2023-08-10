package ro.dragomiralin.awslambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ro.dragomiralin.awslambda.client.JsonPlaceholderService;

@SpringBootApplication
public class AwsLambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaApplication.class, args);
	}

	@Bean
	JsonPlaceholderService jsonPlaceholderService() {
		WebClient client = WebClient.builder()
				.baseUrl("https://jsonplaceholder.typicode.com")
				.build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
		return factory.createClient(JsonPlaceholderService.class);
	}

}
