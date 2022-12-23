package org.webp;

import static org.junit.jupiter.api.Assertions.*;

import javax.ejb.EJB;

import org.junit.jupiter.api.Test;

class PersonEJBTest {

    @EJB
    private PersonEJB personEJB;

    @Test
    void testCreatePerson() {
        Person person = new Person();
        personEJB.createPerson(person);
        assertNotNull(person.getId());
    }

    @Test
    void testFindPerson() {
        Person person = new Person();
        personEJB.createPerson(person);
        Long id = person.getId();
        Person foundPerson = personEJB.findById(id);
        assertEquals(person, foundPerson);
    }

    @Test
    void testUpdatePerson() {
        Person person = new Person();
        personEJB.createPerson(person);
        Long id = person.getId();
        Person foundPerson = personEJB.findById(id);
        foundPerson.setDoor_number(new PersonsDoorRoom());
        personEJB.updatePerson(foundPerson);
        Person updatedPerson = personEJB.findById(id);
        assertEquals(foundPerson, updatedPerson);
    }

    @Test
    void testDeletePerson() {
        Person person = new Person();
        personEJB.createPerson(person);
        Long id = person.getId();
        personEJB.deletePerson(id);
        Person foundPerson = personEJB.findById(id);
        assertNull(foundPerson);
    }
}
