package com.gossan.lmpback.dao;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import com.gossan.lmpback.models.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByLastName (String lastName);
}
