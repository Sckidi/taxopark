package by.grsu.ruduk.taxopark.repository;

import by.grsu.ruduk.taxopark.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  Order findByNumber(String number);
}
