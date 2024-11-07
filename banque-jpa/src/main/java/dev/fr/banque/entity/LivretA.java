package dev.fr.banque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class LivretA extends Compte {

    @Column(name = "taux")
    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double taux) {
        super(numero);
        this.taux = taux;
    }

    /**
     * @return double return the taux
     */
    public double getTaux() {
        return taux;
    }

    /**
     * @param taux the taux to set
     */
    public void setTaux(double taux) {
        this.taux = taux;
    }

}
