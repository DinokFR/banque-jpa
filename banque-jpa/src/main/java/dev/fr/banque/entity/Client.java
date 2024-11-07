package dev.fr.banque.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "dateNaissance")
    private Date dateNaissance;
    @ManyToOne
    @JoinColumn(name = "Banque_ID")
    private Banque banque;

    @ManyToMany
    @JoinTable(name = "Cli_Compte",
            joinColumns = @JoinColumn(name = "ID_Client", referencedColumnName
                    = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_Compte", referencedColumnName
                    = "ID")
    )
    private Set<Compte> comptes = new HashSet<>();  // Initialisation de la collection

    @Embedded
    private Adresse adresse;

    public Client() {
    }

    public Client(String nom, String prenom, Date dateNaissance, Banque banque, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.adresse = adresse;
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
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return Date return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return Banque return the banque
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * @param banque the banque to set
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * @return Set<Compte> return the comptes
     */
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * @param comptes the comptes to set
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    /**
     * @return Adresse return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void addCompte(Compte c) {
        this.comptes.add(c);
    }

}
