package com.gossan.lmuback.service;

import com.gossan.lmuback.dao.PersonRepository;
import com.gossan.lmuback.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private  PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Person person = this.personRepository.findByMail(mail);
        return new User(person.getMail(),
                person.getPassword(),
                AuthorityUtils.createAuthorityList((String[]) person.getRoles().stream().map(r -> r.getName()).toArray()));

    }
}
