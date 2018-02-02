package de.nibu.userservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//FIXME: Make password required remove Constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 4, max = 255)
    private String username;
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    @NotNull
    @Size(min = 1, max = 255)
    private String firstname;
    @NotNull
    @Email
    private String mail;
    private LocalDate birthday;
    private String salt;
    private String password;
    private long iterations;

    public User(long id, String username, String name, String firstname, String mail, LocalDate birthday) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.birthday = birthday;
    }
}
