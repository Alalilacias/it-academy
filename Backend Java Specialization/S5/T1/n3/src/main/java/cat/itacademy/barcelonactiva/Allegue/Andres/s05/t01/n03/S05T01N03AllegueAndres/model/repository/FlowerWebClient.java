package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.model.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FlowerWebClient {
    @Bean
    public WebClient WebClient(){
        return WebClient.builder()
                .baseUrl("""
                        http://localhost:9002""")
                .build();
    }
}
