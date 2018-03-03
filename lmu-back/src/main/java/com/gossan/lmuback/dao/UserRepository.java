package com.gossan.lmuback.dao;


import com.gossan.lmuback.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserRepository extends JpaRepository<User, Long>{

    /*@RestResource(path="lastName")
    List<User> findByLastName (String lastName);*/
    
}
