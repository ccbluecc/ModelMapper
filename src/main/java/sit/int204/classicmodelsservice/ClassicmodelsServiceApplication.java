package sit.int204.classicmodelsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.int204.classicmodelsservice.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ClassicmodelsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassicmodelsServiceApplication.class, args);
    }

}
