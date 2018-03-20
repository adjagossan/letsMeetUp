package com.gossan.lmuback.event;

import com.gossan.lmuback.dao.PersonRepository;
import com.gossan.lmuback.models.Event;
import com.gossan.lmuback.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Event.class)
public class EventHandler {

        @Autowired
        private PersonRepository personRepository;

        @HandleBeforeCreate
        public void applyUserInformationUsingSecurityContext(Event event){
            String mail = SecurityContextHolder.getContext().getAuthentication().getName();
            Person person = this.personRepository.findByMail(mail);
            if(person == null){
                person = new Person();
            }
        }

}
