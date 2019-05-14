package by.grsu.ruduk.taxopark.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String cause;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String aLogin) {
        login = aLogin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String aCause) {
        cause = aCause;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate aDate) {
        date = aDate;
    }
}
