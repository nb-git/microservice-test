package de.nibu.userservice.creation;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_creation_data")
public class UserCreation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Past
    @Column(name = "user_creation_date")
    private LocalDate creationDate;
}
