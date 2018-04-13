package com.gossan.lmuback.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Privilege {

    @Id
    @Column(name = "PRIVILEGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy="privileges")
    private Collection<Role> roles = new ArrayList<>();

    public Privilege(){}

    public Privilege(String name){
        this.name = name;
    }

}
