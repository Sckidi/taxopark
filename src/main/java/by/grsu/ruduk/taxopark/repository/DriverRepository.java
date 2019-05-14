package by.grsu.ruduk.taxopark.repository;

import by.grsu.ruduk.taxopark.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
  List<Driver> findAll();
  Driver findByLicenseNumber(String licenseNumber);
}
