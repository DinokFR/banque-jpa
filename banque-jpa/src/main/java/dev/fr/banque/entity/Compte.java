package dev.fr.banque.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Operation")
public class Compte {

    @Id
    private Integer id;
    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private double solde;

    @OneToMany(mappedBy = "Operation")
    private Set<Operation> operations;

    @ManyToMany
    @JoinTable(name = "Cli_Compte",
            joinColumns = @JoinColumn(name = "ID_Compte", referencedColumnName
                    = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_Client",
                    referencedColumnName
                    = "ID")
    )
    private Set<Client> clients;

}
