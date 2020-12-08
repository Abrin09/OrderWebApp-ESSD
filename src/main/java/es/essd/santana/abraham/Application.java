package es.essd.santana.abraham;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(OrderRepository orderRepository) {
		return args -> {
			OrderEntity order1 = new OrderEntity("Cosas que comprar para Casa");
			order1.setItems(Arrays.asList(
					new ItemEntity("Cerveza", true), 
					new ItemEntity("Levadura"),
					new ItemEntity("Harina")));
			orderRepository.save(order1);

			OrderEntity order2 = new OrderEntity("Cosas del Trabajo que coger");
			order2.setItems(Arrays.asList(
					new ItemEntity("Portatil"), 
					new ItemEntity("Libreta"), 
					new ItemEntity("Dossier")));
			orderRepository.save(order2);
		};
	}
}
