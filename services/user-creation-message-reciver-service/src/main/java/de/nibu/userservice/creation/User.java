package de.nibu.userservice.creation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String name;
    private String firstname;
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
