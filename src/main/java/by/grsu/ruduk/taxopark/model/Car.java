package by.grsu.ruduk.taxopark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;
    private String mark;
    private String bodyType;
    private String year;
    private String fuelType;
}
