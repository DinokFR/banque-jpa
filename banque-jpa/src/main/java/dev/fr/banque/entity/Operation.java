package dev.fr.banque.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    private Date date;

    @Column(name = "montant")
    private Integer montant;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "Compte_ID")
    private Compte compte;

    public Operation() {
    }

    public Operation(Date date, Integer montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Integer return the montant
     */
    public Integer getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    /**
     * @return String return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * @param motif the motif to set
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * @return Compte return the compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * @param compte the compte to set
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }

}
