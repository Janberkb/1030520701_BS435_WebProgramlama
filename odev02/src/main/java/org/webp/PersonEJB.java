package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEJB {

    // EntityManager, veritabanındaki verilerle çalışmak için kullanılır
    @PersistenceContext
    private EntityManager entityManager;

    // Bir Person nesnesi oluşturur ve veritabanına kaydeder
    public void createPerson(Person person) {
        entityManager.persist(person);
    }

    // Veritabanındaki bir Person nesnesini id'sine göre bulur
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    // Veritabanındaki bir Person nesnesini günceller
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    // Veritabanındaki bir Person nesnesini id'sine göre siler
    public void deletePerson(Long id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
