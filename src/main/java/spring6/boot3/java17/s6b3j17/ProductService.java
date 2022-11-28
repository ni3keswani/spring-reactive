package spring6.boot3.java17.s6b3j17;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    Flux<Product> getAll() {
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(2));
    }
}
