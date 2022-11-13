package org.webp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class KeyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @OneToOne(mappedBy = "keycard_id")
    private Person owner_id;

    @OneToOne(mappedBy = "accepted_key_card_id")
    private PersonsDoorRoom door_number;

    public KeyCard(){}

    public Long getId() {
        return id;
    }

    public Person getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Person owner_id) {
        this.owner_id = owner_id;
    }

    public PersonsDoorRoom getDoor_number() {
        return door_number;
    }

    public void setDoor_number(PersonsDoorRoom door_number) {
        this.door_number = door_number;
    }
}
