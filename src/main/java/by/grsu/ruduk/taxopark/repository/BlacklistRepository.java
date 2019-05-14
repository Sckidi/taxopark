package by.grsu.ruduk.taxopark.repository;

import by.grsu.ruduk.taxopark.model.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<BlackList, Long> {
  BlackList findByLogin(String login);
}
