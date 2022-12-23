package org.webp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KeyCardEJB {

    // EntityManager, veritabanındaki verilerle çalışmak için kullanılır
    @PersistenceContext
    private EntityManager entityManager;

    // Bir KeyCard nesnesi oluşturur ve veritabanına kaydeder
    public void createKeyCard(KeyCard keyCard) {
        entityManager.persist(keyCard);
    }

    // Veritabanındaki bir KeyCard nesnesini id'sine göre bulur
    public KeyCard findById(Long id) {
        return entityManager.find(KeyCard.class, id);
    }

    // Veritabanındaki bir KeyCard nesnesini günceller
    public void updateKeyCard(KeyCard keyCard) {
        entityManager.merge(keyCard);
    }

    // Veritabanındaki bir KeyCard nesnesini id'sine göre siler
    public void deleteKeyCard(Long id) {
        KeyCard keyCard = findById(id);
        entityManager.remove(keyCard);
    }
}
