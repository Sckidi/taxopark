package by.grsu.ruduk.taxopark.config;

import by.grsu.ruduk.taxopark.model.Role;
import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class InitDataLoader implements ApplicationRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleUser = createRoleIfNotFound("ROLE_USER");

        User user = new User();
        user.setName("Кирилл Олегович");
        user.setUsername("ruduk");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setRoles(asList(roleUser));
    }

    @Transactional
    public Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByRolename(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
