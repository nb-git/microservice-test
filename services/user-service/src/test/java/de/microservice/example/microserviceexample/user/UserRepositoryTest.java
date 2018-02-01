package de.microservice.example.microserviceexample.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void findAll() {
        Long id = repository.count() + 1;
        User user = new User(id, "Testuser", "Test", "Test", "test@test.de", LocalDate.of(1989, 1, 1));
        repository.save(user);
        List<User> result = repository.findAll();
        assertThat(result, not(emptyCollectionOf(User.class)));
    }

    @Test
    public void createNew() {
        Long id = repository.count() + 1;
        User user = new User(id, "Testuser", "Test", "Test", "test@test.de", LocalDate.of(1989, 1, 1));
        repository.save(user);
        User result = repository.findOne(id);
        assertNotNull(result);
        assertEquals(result.getName(), user.getName());
        assertEquals(result.getFirstname(), user.getFirstname());
        assertEquals(result.getId(), id);
    }

    @Test
    public void findNotExistingUser() {
        Long id = repository.count() + 1;
        User result = repository.findOne(id);
        assertNull(result);
    }

}