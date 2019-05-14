package by.grsu.ruduk.taxopark.config;

import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setName("Кирилл Олегович");
        user.setUsername("ruduk");
        user.setPassword(passwordEncoder.encode("12345"));
        userRepository.save(user);
    }
}
