package com.gossan.lmuback.models;

import com.gossan.lmuback.dao.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class EventEntityTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private EventRepository eventRepository;

    private Topic topic;
    private Event event;
    private State state, otherState, organizer_state;
    private Person organizer, p1, p2;
    private Collection<Person> participants = new ArrayList<>();

    @Before
    public void setup(){
        event = new Event();
        topic = new Topic("Blockchain");

        state = new State("Côte d'Ivoire");
        otherState = new State("Senegal");
        organizer_state = new State("Usa");
        organizer = new Person(Civility.MONSIEUR,"ADJA", "Gossan", "","adjagossan@gmail.com","04242276");
        Address addressEvent = new Address("cesson","Rennes","35510");
        Address addressPerson = new Address("beaulieu", "Rennes","35700");
        organizer.setAddress(addressPerson);
        organizer.addEvent(event);
        organizer.setState(organizer_state);

        p1 = new Person(Civility.MADAME, "ADJA", "Arielle", "","adjaarielle@gmail.com", "77450023");
        p1.setAddress(new Address("cocody", "Abidjan", "5000"));
        p1.setState(otherState);
        p1.addVisitedEvent(this.event);

        p2 = new Person(Civility.MADEMOISELLE, "ZOKOU", "Rita", "","zokou@outlook.com", "45201223");
        p2.setAddress(new Address("EMPT", "Bingerville", "4800"));
        p2.setState(state);
        p2.addVisitedEvent(this.event);

        this.participants.add(p1);
        this.participants.add(p2);

        event.setParticipants(this.participants);
        event.setName("Information technology");
        event.setDescription("let's meet up to talk about blockchain");
        event.setImage("image_path");
        event.setStartDate(new Date(2018, 03, 14));
        event.setEndDate(new Date(2018, 03, 14));
        event.setAddress(addressEvent);
        event.setTopic(topic);
        event.setState(state);
        event.setOrganizer(organizer);

    }

    @Test
    public void crudEvent(){
        //Create - read
        this.em.persist(topic);
        this.em.persist(organizer);
        this.em.persist(p1);
        this.em.persist(p2);
        this.em.persist(state);
        this.em.persist(organizer_state);
        this.em.persist(otherState);
        this.em.persist(event);

        Event myEvent = this.eventRepository.findOne(event.getId());

        Assertions.assertThat(myEvent).isNotNull();
        Assertions.assertThat(myEvent).isEqualTo(event);
        Assertions.assertThat(myEvent).hasFieldOrPropertyWithValue("name", "Information technology");
        Assertions.assertThat(myEvent).hasFieldOrPropertyWithValue("topic", topic);
        Assertions.assertThat(myEvent.getTopic()).hasFieldOrPropertyWithValue("value", "Blockchain");
        Assertions.assertThat(myEvent).hasFieldOrPropertyWithValue("organizer", organizer);
        Assertions.assertThat(myEvent.getOrganizer()).hasFieldOrPropertyWithValue("firstName", "ADJA");
        Assertions.assertThat(myEvent.getParticipants()).hasSize(2);


        //Update
        myEvent.setName("Digital economy");
        myEvent.getTopic().setValue("Information system");
        myEvent.getOrganizer().setFirstName("Gossan");
        this.em.persist(myEvent);
        Assertions.assertThat(myEvent).hasFieldOrPropertyWithValue("name", "Digital economy");
        Assertions.assertThat(myEvent.getTopic()).hasFieldOrPropertyWithValue("value", "Information system");
        Assertions.assertThat(myEvent.getOrganizer()).hasFieldOrPropertyWithValue("firstName", "Gossan");
        /*
        persistedEvent.setName("Digital economy");
        persistedEvent.getTopic().setValue("Information system");
        this.em.persist(persistedEvent);
        this.em.flush();*/

        /*
        Event found_event = this.em.find(Event.class, 1);
        Assert.assertNotNull("Event : an error occured", found_event);
        Assert.assertEquals("Topic : An error occured", persistedEvent.getTopic().getValue(), "Information system");
        Assert.assertEquals("Event: an error occured", persistedEvent.getName(), "Digital economy");
        Assert.assertEquals("Event.organizer : an error occured", persistedEvent.getOrganizer().getFirstName(), "ADJA");
        */
        //Delete
        /*this.em.remove(found_event);
        this.em.flush();
        Event evt = this.em.find(Event.class, 1);
        Assert.assertNull("Event : an error occured", evt);*/

    }

    @Test
    public void getEvent(){
    }

    @Test
    public void getName(){
    }
}
