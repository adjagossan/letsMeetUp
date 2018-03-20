package com.gossan.lmuback.dao;

import com.gossan.lmuback.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "roles", path="role", exported = false)
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
