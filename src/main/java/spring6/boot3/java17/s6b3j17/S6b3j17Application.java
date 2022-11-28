package spring6.boot3.java17.s6b3j17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class S6b3j17Application {

    public static void main(String[] args) {
        SpringApplication.run(S6b3j17Application.class, args);
    }

    @Autowired
    ProductService productService;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .GET("/productViaRoutes", request -> ok().contentType(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE)).body(productService.getAll(), Product.class))
                .build();
    }

}
