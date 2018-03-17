package com.gossan.lmuback.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Person {

    @Id
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String password;

    @ManyToMany
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
        this.password = password;
        this.mail = mail;
        this.numberPhone = numberPhone;
        this.civility = civility;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Collection<Event> getCreatedEvent() {
        return createdEvent;
    }

    public void setCreatedEvent(Collection<Event> createdEvent) {
        this.createdEvent = createdEvent;
    }

    public void addEvent(Event evt){
        this.createdEvent.add(evt);
    }

    public void addEventAll(Collection<Event> events){
        this.createdEvent.addAll(events);
    }

    public Collection<Event> getAssistedEvent() {
        return assistedEvent;
    }

    public void setAssistedEvent(Collection<Event> assistedEvent) {
        this.assistedEvent = assistedEvent;
    }

    public void addVisitedEvent(Event evt){
        this.assistedEvent.add(evt);
    }

    public void addVisitedEventAll(Collection<Event> events){
        this.assistedEvent.addAll(events);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
