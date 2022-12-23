package org.webp;

import static org.junit.jupiter.api.Assertions.*;

import javax.ejb.EJB;

import org.junit.jupiter.api.Test;

class PersonsDoorRoomEJBTest {

    @EJB
    private PersonsDoorRoomEJB personsDoorRoomEJB;

    @Test
    void testCreatePersonsDoorRoom() {
        PersonsDoorRoom personsDoorRoom = new PersonsDoorRoom();
        personsDoorRoomEJB.createPersonsDoorRoom(personsDoorRoom);
        assertNotNull(personsDoorRoom.getId());
    }

    @Test
    void testFindPersonsDoorRoom() {
        PersonsDoorRoom personsDoorRoom = new PersonsDoorRoom();
        personsDoorRoomEJB.createPersonsDoorRoom(personsDoorRoom);
        Long id = personsDoorRoom.getId();
        PersonsDoorRoom foundPersonsDoorRoom = personsDoorRoomEJB.findById(id);
        assertEquals(personsDoorRoom, foundPersonsDoorRoom);
    }

    @Test
    void testUpdatePersonsDoorRoom() {
        PersonsDoorRoom personsDoorRoom = new PersonsDoorRoom();
        personsDoorRoomEJB.createPersonsDoorRoom(personsDoorRoom);
        Long id = personsDoorRoom.getId();
        PersonsDoorRoom foundPersonsDoorRoom = personsDoorRoomEJB.findById(id);
        foundPersonsDoorRoom.setOwner_id(new Person());
        personsDoorRoomEJB.updatePersonsDoorRoom(foundPersonsDoorRoom);
        PersonsDoorRoom updatedPersonsDoorRoom = personsDoorRoomEJB.findById(id);
        assertEquals(foundPersonsDoorRoom, updatedPersonsDoorRoom);
    }

    @Test
    void testDeletePersonsDoorRoom() {
        PersonsDoorRoom personsDoorRoom = new PersonsDoorRoom();
        personsDoorRoomEJB.createPersonsDoorRoom(personsDoorRoom);
        Long id = personsDoorRoom.getId();
        personsDoorRoomEJB.deletePersonsDoorRoom(id);
        PersonsDoorRoom foundPersonsDoorRoom = personsDoorRoomEJB.findById(id);
        assertNull(foundPersonsDoorRoom);
    }
}
