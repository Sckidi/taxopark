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

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String aMark) {
        mark = aMark;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String aBodyType) {
        bodyType = aBodyType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String aYear) {
        year = aYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String aFuelType) {
        fuelType = aFuelType;
    }
}
