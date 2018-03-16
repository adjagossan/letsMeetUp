package com.gossan.lmuback.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @Column(name="ROLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy="roles")
    private Collection<Person> persons = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "ROLE_PRIVILEGE",
            joinColumns = { @JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = { @JoinColumn(name = "PRIVILEGE_ID")}
    )
    private Collection<Privilege> privileges = new ArrayList<>();

    public Role(){}

    public Role(String name){
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

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
