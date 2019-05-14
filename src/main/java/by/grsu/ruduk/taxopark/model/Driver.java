package by.grsu.ruduk.taxopark.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String aLicenseNumber) {
        licenseNumber = aLicenseNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate aDate) {
        date = aDate;
    }
}
