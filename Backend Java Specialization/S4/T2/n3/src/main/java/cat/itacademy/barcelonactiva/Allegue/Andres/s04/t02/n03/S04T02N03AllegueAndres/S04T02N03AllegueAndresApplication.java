package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class S04T02N03AllegueAndresApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03AllegueAndresApplication.class, args);
	}

}
