package de.nibu.userservice.creation;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    String CREATION_BROADCASTS = "userCreationBroadcasts";
    String UPDATE_BROADCASTS = "userUpdateBroadcasts";
    String DELETION_BROADCASTS = "userDeleteBroadcasts";

    @Input(CREATION_BROADCASTS)
    SubscribableChannel userCreation();

    @Input(UPDATE_BROADCASTS)
    SubscribableChannel userUpdate();

    @Input(DELETION_BROADCASTS)
    SubscribableChannel userDeletion();
}
