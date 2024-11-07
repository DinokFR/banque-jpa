package dev.fr.banque.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private double solde;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Cli_Compte",
            joinColumns = @JoinColumn(name = "ID_Compte", referencedColumnName
                    = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_Client",
                    referencedColumnName
                    = "ID")
    )
    private Set<Client> clients = new HashSet<>();

    public Compte() {
    }

    public Compte(String numero) {
        this.numero = numero;
        this.solde = 0;
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
     * @return String return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return double return the solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * @return Set<Operation> return the operations
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * @param operations the operations to set
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    /**
     * @return Set<Client> return the clients
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addOpe(Operation o){
        this.operations.add(o);
    }

    public void addClient(Client c){
        this.clients.add(c);
    }

}
