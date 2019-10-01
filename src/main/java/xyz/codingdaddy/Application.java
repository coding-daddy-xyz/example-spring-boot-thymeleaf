package xyz.codingdaddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * Thymeleaf String Boot application example
 *
 * @author serhiy
 */
@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        Stream.of("admin", "user").forEach(u -> {
            userRepository.save(User.of(u, u, u + "@example.com"));
        });
    }
}