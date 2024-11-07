package dev.fr.banque.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operation")
public class Operation {

    @Id
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

}
