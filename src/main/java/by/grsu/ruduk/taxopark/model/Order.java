package by.grsu.ruduk.taxopark.model;

import by.grsu.ruduk.taxopark.model.constants.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "_order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String number;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate receivingDate;
  private String address;
  private String driverId;
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String aDescription) {
    description = aDescription;
  }

  @Enumerated
  private OrderStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long aId) {
    id = aId;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String aNumber) {
    number = aNumber;
  }

  public LocalDate getReceivingDate() {
    return receivingDate;
  }

  public void setReceivingDate(LocalDate aReceivingDate) {
    receivingDate = aReceivingDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String aAddress) {
    address = aAddress;
  }

  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String aDriverId) {
    driverId = aDriverId;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus aStatus) {
    status = aStatus;
  }
}
