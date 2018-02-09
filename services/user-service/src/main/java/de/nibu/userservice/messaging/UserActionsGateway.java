package de.nibu.userservice.messaging;

import de.nibu.userservice.user.ProducerChannels;
import de.nibu.userservice.user.User;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface UserActionsGateway {

    @Gateway( requestChannel = ProducerChannels.CREATE)
    void broadcastCreation(User user);

    @Gateway( requestChannel = ProducerChannels.UPDATE)
    void broadcastUpdate(User user);

    @Gateway( requestChannel = ProducerChannels.DELETE)
    void broadcastDelete(Long userId);
}
