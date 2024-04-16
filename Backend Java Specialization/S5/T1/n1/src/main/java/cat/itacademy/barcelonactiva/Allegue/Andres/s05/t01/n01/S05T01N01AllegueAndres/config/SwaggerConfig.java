package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Branch Project API Documentation")
                .description("API documentation for the Sprint 5, Task 1, level 1, Branch Spring Boot project")
                .version("1.0")
                .build();
    }
}
