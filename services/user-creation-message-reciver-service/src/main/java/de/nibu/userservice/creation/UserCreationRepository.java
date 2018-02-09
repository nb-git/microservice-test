package de.nibu.userservice.creation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCreationRepository extends CrudRepository<UserCreation, Long> {
    List<UserCreation> findAll();
}
