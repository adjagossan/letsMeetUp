package com.gossan.lmuback.handler.event;

import com.gossan.lmuback.dao.PersonRepository;
import com.gossan.lmuback.models.Civility;
import com.gossan.lmuback.models.Event;
import com.gossan.lmuback.models.Person;
import com.gossan.lmuback.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Arrays;

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
                person = new Person(Civility.MADAME, "Ghislaine",
                        "AHOU", "secret",
                        "ahou@outlook.com", "22222222",
                        Arrays.asList(new Role("ORGANIZER")));
                personRepository.save(person);
            }
            event.setOrganizer(person);
        }

}
