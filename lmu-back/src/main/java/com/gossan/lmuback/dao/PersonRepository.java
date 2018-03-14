package com.gossan.lmuback.dao;

import com.gossan.lmuback.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "person", path="person")
public interface PersonRepository /*extends JpaRepository<Person, Long>*/ {
}
