package com.gossan.lmuback.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
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

}
