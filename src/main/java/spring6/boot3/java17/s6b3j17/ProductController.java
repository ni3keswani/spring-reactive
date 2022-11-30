package spring6.boot3.java17.s6b3j17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Product> getAll() {
        Flux<Product> all = productService.getAll();
        ReactiveSecurityContextHolder
                .getContext()
                .map(e -> e.getAuthentication())
                .log()
                .doOnSuccess(e -> System.out.print(e.toString()))
                .subscribe();
        return all;
    }

    @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<String> demo() {
        Flux<String> all = Flux.fromArray("Manav Jeevika Khushboo Nitin , Nanak Keswani".split(" "));
        return all
                .filter(e -> e.length() % 2 == 0)
                .log()
                .delayElements(Duration.ofSeconds(1));
    }
}
