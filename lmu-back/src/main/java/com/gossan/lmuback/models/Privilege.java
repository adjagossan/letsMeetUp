package com.gossan.lmuback.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @Column(name = "PRIVILEGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy="privileges")
    private Collection<Role> roles = new ArrayList<>();

    public Privilege(){}

    public Privilege(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}
