package org.webp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PersonsDoorRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @OneToOne(mappedBy = "door_number")
    private Person owner_id;

    @OneToOne
    private KeyCard accepted_key_card_id;

    public PersonsDoorRoom() {
    }

    public Long getId() {
        return id;
    }

    public Person getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Person owner_id) {
        this.owner_id = owner_id;
    }

    public KeyCard getAccepted_key_card_id() {
        return accepted_key_card_id;
    }

    public void setAccepted_key_card_id(KeyCard accepted_key_card_id) {
        this.accepted_key_card_id = accepted_key_card_id;
    }
}
