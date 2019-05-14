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
    @Enumerated
    private OrderStatus status;
}
