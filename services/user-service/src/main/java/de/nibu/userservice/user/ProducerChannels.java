package de.nibu.userservice.user;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannels {

    String CREATE = "userCreationBroadcast";
    String UPDATE = "userUpdateBroadcast";
    String DELETE = "userDeleteBroadcast";

    @Output(CREATE)
    MessageChannel userCreation();

    @Output(UPDATE)
    MessageChannel userUpdate();

    @Output(DELETE)
    MessageChannel userDelete();

}
