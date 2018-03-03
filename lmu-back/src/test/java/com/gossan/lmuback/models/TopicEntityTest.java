package com.gossan.lmuback.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicEntityTest {

    @Autowired
    private TestEntityManager em;

    private Topic topic;

    @Before
    public void setup(){
        topic = new Topic("Blockchain");
    }

    @Test
    public void saveTopic(){
        Topic tp = this.em.persistAndFlush(topic);
        Assert.assertEquals("An error occured", tp.getValue(), "Blockchain");
    }
}
