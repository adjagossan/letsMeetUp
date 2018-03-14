package com.gossan.lmuback.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventEntityTest {

    @Autowired
    private TestEntityManager em;
    private Topic topic;
    private Event event;
    private State state, organizer_state;
    private Person organizer;

    @Before
    public void setup(){
        event = new Event();
        topic = new Topic("Blockchain");
        state = new State("Abidjan");
        organizer_state = new State("New-york");
        organizer = new Person(Civility.MONSIEUR,"ADJA", "Gossan", "adjagossan@gmail.com","04242276");
        Address addressEvent = new Address("cesson","Rennes","35510");
        Address addressPerson = new Address("beaulieu", "Rennes","35700");
        organizer.setAddress(addressPerson);
        organizer.addEvent(event);
        organizer.setState(organizer_state);
        event.setTopic(topic);
        event.setState(state);
        event.setOrganizer(organizer);
        event.setName("Information technology");
        event.setDescription("let's meet up to talk about blockchain");
        event.setImage("image_path");
        event.setStartDate(new Date(2018, 03, 14));
        event.setEndDate(new Date(2018, 03, 14));
        event.setAddress(addressEvent);
    }

    @Test
    public void crudEvent(){
        //Create - read
        this.em.persist(topic);
        this.em.persist(organizer);
        this.em.persist(state);
        this.em.persist(organizer_state);
        Event persistedEvent = this.em.persistFlushFind(event);
        Assert.assertNotNull("Event : an error occured : null instance", persistedEvent);
        Assert.assertTrue("Event, testing entity id : an error occured", persistedEvent.getId() == 1);
        Assert.assertEquals("Topic : An error occured", persistedEvent.getTopic().getValue(), "Blockchain");
        Assert.assertEquals("Event: an error occured", persistedEvent.getName(), "Information technology");
        Assert.assertEquals("Event.organizer : an error occured", persistedEvent.getOrganizer().getFirstName(), "ADJA");
        //Update
        persistedEvent.setName("Digital economy");
        persistedEvent.getTopic().setValue("Information system");
        this.em.flush();
        Event found_event = this.em.find(Event.class, 1);
        Assert.assertNotNull("Event : an error occured", found_event);
        Assert.assertEquals("Topic : An error occured", persistedEvent.getTopic().getValue(), "Information system");
        Assert.assertEquals("Event: an error occured", persistedEvent.getName(), "Digital economy");
        Assert.assertEquals("Event.organizer : an error occured", persistedEvent.getOrganizer().getFirstName(), "ADJA");
        //Delete
        this.em.remove(found_event);
        this.em.flush();
        Event evt = this.em.find(Event.class, 1);
        Assert.assertNull("Event : an error occured", evt);
    }

    @Test
    public void getEvent(){
    }

    @Test
    public void getName(){
    }
}
