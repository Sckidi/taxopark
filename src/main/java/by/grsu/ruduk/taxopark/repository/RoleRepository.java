package by.grsu.ruduk.taxopark.repository;

import by.grsu.ruduk.taxopark.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRolename(String name);
}
