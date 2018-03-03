package com.gossan.lmuback.util;

import com.gossan.lmuback.dao.UserRepository;
import com.gossan.lmuback.models.Address;
import com.gossan.lmuback.models.Civility;
import com.gossan.lmuback.models.State;
import com.gossan.lmuback.models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/*@Component
public class RepoCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RepoCommandLineRunner.class);
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        User user = new User();
        user.setFirstName("Gossan");
        user.setLastName("ADJA");
        user.setCivility(Civility.MONSIEUR);
        user.setMail("adjagossan@gmail.com");
        user.setNumberPhone("0768338889");
        Address address = new Address("CESSON", "RENNES", "35510");
        State state = new State();
        //address.setState(state);
        user.setAddress(address);

        log.info("---------------------------------");
        log.info("Finding all users");
        log.info("---------------------------------");
        for(User us : userRepository.findAll())
            log.info(us.toString());
    }
}*/
