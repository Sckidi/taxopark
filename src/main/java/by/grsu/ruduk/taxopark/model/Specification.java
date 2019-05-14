package by.grsu.ruduk.taxopark.model;

import by.grsu.ruduk.taxopark.model.constants.UnitType;

import javax.persistence.*;

@Entity
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double engineCapacity;
    private String fuelType;
    private Double fuelConsumption;
    @Enumerated
    private UnitType unit;

}
