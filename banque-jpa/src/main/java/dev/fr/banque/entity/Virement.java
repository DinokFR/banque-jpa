package dev.fr.banque.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Virement extends Operation {

    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(Date date, Integer montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    /**
     * @return String return the beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * @param beneficiaire the beneficiaire to set
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

}
