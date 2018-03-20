package com.gossan.lmuback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@ToString(exclude = "password")
public class Person implements Serializable {

    @Id
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PERSON_ROLE",
            joinColumns = { @JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID")}
    )
    private Collection<Role> roles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Civility civility;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private State state;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String mail;

    @NotEmpty
    private String numberPhone;

    private String imagePath;

    private boolean activated = false;

    @OneToMany (mappedBy = "organizer")
    private Collection<Event> createdEvent = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "PERSON_EVENT",
            joinColumns = { @JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = { @JoinColumn(name = "EVENT_ID")}
    )
    private Collection<Event> assistedEvent = new ArrayList<>();

    public Person(){
    }

    public Person(Civility civility, String firstName, String lastName,
                  String password, String mail, String numberPhone, Collection<Role> roles){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mail = mail;
        this.numberPhone = numberPhone;
        this.civility = civility;
        this.roles = roles;
    }

    public Person(Civility civility, String firstName, String lastName,
                  String password, String mail, String numberPhone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.setPassword(password);
        this.mail = mail;
        this.numberPhone = numberPhone;
        this.civility = civility;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
