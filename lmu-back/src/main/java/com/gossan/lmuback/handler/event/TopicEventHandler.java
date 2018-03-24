package com.gossan.lmuback.handler.event;

import com.gossan.lmuback.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import static com.gossan.lmuback.util.WebSocketConfiguration.MESSAGE_PREFIX;

@Component
@RepositoryEventHandler(Topic.class)
public class TopicEventHandler {

    private final EntityLinks entityLinks;

    private final SimpMessagingTemplate websocket;

    @Autowired
    public TopicEventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks){
        this.websocket = websocket;
        this.entityLinks = entityLinks;
    }

    @HandleAfterCreate
    public void newTopic(Topic topic){
        this.websocket.convertAndSend(MESSAGE_PREFIX + "/newTopic", getPath(topic));
    }

    @HandleAfterSave
    public void updateEmployee(Topic topic){
        this.websocket.convertAndSend(MESSAGE_PREFIX + "/updateEmployee", getPath(topic));
    }

    private String getPath(Topic topic){
        return this.entityLinks.linkForSingleResource(topic.getClass(), topic.getId()).toUri().getPath();
    }
}
