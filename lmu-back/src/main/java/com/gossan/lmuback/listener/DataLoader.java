package com.gossan.lmuback.listener;

import com.gossan.lmuback.dao.PersonRepository;
import com.gossan.lmuback.dao.PrivilegeRepository;
import com.gossan.lmuback.dao.RoleRepository;
import com.gossan.lmuback.models.Civility;
import com.gossan.lmuback.models.Person;
import com.gossan.lmuback.models.Privilege;
import com.gossan.lmuback.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean loaded = false;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    Privilege newPrivilege(final String name){
        Privilege p = privilegeRepository.findByName(name);
        if(p == null){
            p = new Privilege(name);
            privilegeRepository.saveAndFlush(p);
        }
        return p;
    }

    @Transactional
    Role newRole(final String name, final Collection<Privilege> priv){
        Role r = roleRepository.findByName(name);
        if(r == null){
            r = new Role(name);
        }
        r.setPrivileges(priv);
        roleRepository.saveAndFlush(r);
        return r;
    }

    @Transactional
    Person newPerson(final Civility civility, final String firstName, final String lastName, final String password,
                     final String mail, String numberPhone, final Collection<Role> roles){
        Person p = personRepository.findByMail(mail);
        if(p == null){
            p = new Person(civility, firstName, lastName, passwordEncoder.encode(password), mail, numberPhone);
        }
        p.setRoles(roles);
        personRepository.saveAndFlush(p);
        return p;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (loaded)
            return;

        final Privilege reading = newPrivilege("READING");
        final Privilege writing = newPrivilege("WRITING");
        final Privilege change_password = newPrivilege("CHANGE_PASSWORD");


        /*final Role organizer = newRole("ORGANIZER");
        final Role user = newRole("USER");*/

        final Collection<Privilege> organizer_privilege = new ArrayList<>(Arrays.asList(reading, writing, change_password));
        final Collection<Privilege> user_privilege = new ArrayList<>(Arrays.asList(writing, change_password));

        /*organizer.setPrivileges(organizer_privilege);
        user.setPrivileges(user_privilege);*/

        final Role organizer = newRole("ORGANIZER", organizer_privilege);
        final Role user = newRole("USER", user_privilege);

        newPerson(Civility.MONSIEUR, "Gossan", "ADJA", "password",
                "adjagossan@gmail.com", "00000000", new ArrayList<>(Arrays.asList(organizer)));

        loaded = true;

    }
}
