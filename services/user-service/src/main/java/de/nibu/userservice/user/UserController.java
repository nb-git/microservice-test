package de.nibu.userservice.user;

import de.nibu.userservice.messaging.UserActionsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    private final UserActionsGateway gateway;

    @Autowired
    public UserController(UserRepository userRepository, UserActionsGateway gateway){
        this.userRepository = userRepository;
        this.gateway = gateway;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User result = userRepository.save(user);
        gateway.broadcastCreation(result);
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User result = userRepository.save(user);
        gateway.broadcastUpdate(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userRepository.delete(id);
        gateway.broadcastDelete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> user(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findOne(id), HttpStatus.OK);

    }
}
