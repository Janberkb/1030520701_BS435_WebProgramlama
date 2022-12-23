package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonsDoorRoomEJB {

    // EntityManager, veritabanındaki verilerle çalışmak için kullanılır
    @PersistenceContext
    private EntityManager entityManager;

    // Bir PersonsDoorRoom nesnesi oluşturur ve veritabanına kaydeder
    public void createPersonsDoorRoom(PersonsDoorRoom personsDoorRoom) {
        entityManager.persist(personsDoorRoom);
    }

    // Veritabanındaki bir PersonsDoorRoom nesnesini id'sine göre bulur
    public PersonsDoorRoom findById(Long id) {
        return entityManager.find(PersonsDoorRoom.class, id);
    }

    // Veritabanındaki bir PersonsDoorRoom nesnesini günceller
    public void updatePersonsDoorRoom(PersonsDoorRoom personsDoorRoom) {
        entityManager.merge(personsDoorRoom);
    }

    // Veritabanındaki bir PersonsDoorRoom nesnesini id'sine göre siler
    public void deletePersonsDoorRoom(Long id) {
        PersonsDoorRoom personsDoorRoom = findById(id);
        entityManager.remove(personsDoorRoom);
    }
}
