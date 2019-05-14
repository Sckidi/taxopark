package by.grsu.ruduk.taxopark.model;

import by.grsu.ruduk.taxopark.model.constants.OrderStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private LocalDate receivingDate;
    private LocalTime receivingTime;
    private String address;
    private String driverId;
    @Enumerated
    private OrderStatus status;
}
