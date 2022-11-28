package spring6.boot3.java17.s6b3j17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ProductHandler {
    @Autowired
    ProductService productService;

    Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        Mono<ServerResponse> body = ok().contentType(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
                .body(productService.getAll(), Product.class);
        return body;
    }
}
