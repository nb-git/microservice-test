package de.microservice.example.microserviceexample.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = POST)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(method = PUT)
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/delete", method = POST)
    public void delete(@RequestBody User user) {
        userRepository.delete(user);
    }

    @RequestMapping(path = "/list")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "{id}")
    public User user(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}
