package org.webp;

import static org.junit.jupiter.api.Assertions.*;

import javax.ejb.EJB;

import org.junit.jupiter.api.Test;

class KeyCardEJBTest {

    @EJB
    private KeyCardEJB keyCardEJB;

    @Test
    void testCreateKeyCard() {
        KeyCard keyCard = new KeyCard();
        keyCardEJB.createKeyCard(keyCard);
        assertNotNull(keyCard.getId());
    }

    @Test
    void testFindKeyCard() {
        KeyCard keyCard = new KeyCard();
        keyCardEJB.createKeyCard(keyCard);
        Long id = keyCard.getId();
        KeyCard foundKeyCard = keyCardEJB.findById(id);
        assertEquals(keyCard, foundKeyCard);
    }

    @Test
    void testUpdateKeyCard() {
        KeyCard keyCard = new KeyCard();
        keyCardEJB.createKeyCard(keyCard);
        Long id = keyCard.getId();
        KeyCard foundKeyCard = keyCardEJB.findById(id);
        foundKeyCard.setOwner_id(new Person());
        keyCardEJB.updateKeyCard(foundKeyCard);
        KeyCard updatedKeyCard = keyCardEJB.findById(id);
        assertEquals(foundKeyCard, updatedKeyCard);
    }

    @Test
    void testDeleteKeyCard() {
        KeyCard keyCard = new KeyCard();
        keyCardEJB.createKeyCard(keyCard);
        Long id = keyCard.getId();
        keyCardEJB.deleteKeyCard(id);
        KeyCard foundKeyCard = keyCardEJB.findById(id);
        assertNull(foundKeyCard);
    }
}
