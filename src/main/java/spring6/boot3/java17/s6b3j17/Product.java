package spring6.boot3.java17.s6b3j17;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    @Id
    Integer id;
    String name;
}
