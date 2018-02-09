package de.nibu.userservice.creation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserCreationService {

    private ConsumerChannels channels;
    private UserCreationRepository userCreationRepo;

    @Autowired
    public UserCreationService(UserCreationRepository userCreationRepo, ConsumerChannels channels){
        this.channels=channels;
        this.userCreationRepo = userCreationRepo;
    }

    @StreamListener(ConsumerChannels.CREATION_BROADCASTS)
    public void createCrationDataset(User user){
        UserCreation userCreationData = new UserCreation();
        userCreationData.setCreationDate(LocalDate.now());
        userCreationData.setUsername(user.getUsername());
        userCreationRepo.save(userCreationData);
    }



}
