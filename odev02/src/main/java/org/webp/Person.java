package org.webp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @OneToOne
    private PersonsDoorRoom door_number;

    @OneToOne
    private KeyCard keycard_id;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public PersonsDoorRoom getDoor_number() {
        return door_number;
    }

    public void setDoor_number(PersonsDoorRoom door_number) {
        this.door_number = door_number;
    }

    public KeyCard getKeycard_id() {
        return keycard_id;
    }

    public void setKeycard_id(KeyCard keycard_id) {
        this.keycard_id = keycard_id;
    }
}
