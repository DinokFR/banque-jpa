package dev.fr.banque.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {

    @Column(name = "dateFin")
    private Date dateFin;
    @Column(name = "taux")
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, Date dateFin, double taux) {
        super(numero);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * @return Date return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
