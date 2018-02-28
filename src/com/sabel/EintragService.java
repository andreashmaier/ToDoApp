package com.sabel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EintragService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EintragService() {
        emf = Persistence.createEntityManagerFactory("eintrag");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        em = null;

        if (emf != null) {
            emf.close();
        }
        emf = null;
    }

    public void speichern(Eintrag eintrag) {
        em.getTransaction().begin();
        em.persist(eintrag);
        em.getTransaction().commit();
    }

    public List<Eintrag> gibtAlleEintraege() {
        TypedQuery<Eintrag> query = em.createQuery("SELECT e from Eintrag e", Eintrag.class);
        return query.getResultList();
    }

    public static void main(String[] args) {
        EintragService eintragService = new EintragService();
        Eintrag eintrag = new Eintrag("Hello");
//        eintragService.speichern(eintrag);
        for (Eintrag eintrag1 : eintragService.gibtAlleEintraege()) {
            System.out.println(eintrag1);
        }
        eintragService.close();
    }

}
