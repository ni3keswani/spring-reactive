package spring6.boot3.java17.s6b3j17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class S6b3j17Application {

    public static void main(String[] args) {
        SpringApplication.run(S6b3j17Application.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routes(ProductHandler productHandler) {
        return route()
                .GET("/productViaRoutes", productHandler::getAll)
                .build();
    }

}
