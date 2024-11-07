package dev;

import java.util.Date;

import dev.fr.banque.entity.Adresse;
import dev.fr.banque.entity.AssuranceVie;
import dev.fr.banque.entity.Banque;
import dev.fr.banque.entity.Client;
import dev.fr.banque.entity.Compte;
import dev.fr.banque.entity.LivretA;
import dev.fr.banque.entity.Operation;
import dev.fr.banque.entity.Virement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Création de l'EntityManagerFactory à partir du fichier persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");

        // Création de l'EntityManager
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Adresse a = new Adresse(465, "41 rue de la pomme rouge", 67320, "Strasbourg");
        Banque banque = new Banque("Banque Socialiste De France");
        Date d = new Date(1621243200000L);
        Client client = new Client("La-Chaussette", "Jean-Louis", d, banque, a);
        Compte compte = new Compte("8974651");
        Operation ope = new Operation(d, 12000, "Vente", compte);

        Client client2 = new Client("Fromage", "Bernard", d, banque, a);
        compte.addClient(client);
        compte.addClient(client2);
        compte.setSolde(0);
        compte.addOpe(ope);

        em.persist(banque);
        em.persist(client);
        em.persist(client2);
        em.persist(compte);
        em.persist(ope);

        LivretA livret = new LivretA("894465", 1);
        AssuranceVie av = new AssuranceVie("89165", d, 5);
        Client client3 = new Client("Saucisse", "Jean", d, banque, a);
        client3.addCompte(livret);
        client3.addCompte(av);

        em.persist(livret);
        em.persist(av);
        em.persist(client3);

        Virement v = new Virement(d, 840, "J'aime les pommes", compte, "Bob");
        Virement v2 = new Virement(d, 489, "J'aime les poires", compte, "Bob");

        compte.addOpe(v);
        compte.addOpe(v2);
        em.persist(v);
        em.persist(v2);
        em.persist(compte);
        transaction.commit();
        em.close();
        emf.close();
    }
}
