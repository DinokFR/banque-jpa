package dev.fr.banque.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "rue")
    private String rue;

    @Column(name = "codePostal")
    private Integer codePostal;

    @Column(name = "ville")
    private String ville;

    public Adresse() {
    }

    public Adresse(Integer num, String rue, Integer code, String ville) {
        this.numero = num;
        this.rue = rue;
        this.codePostal = code;
        this.ville = ville;
    }

    /**
     * @return Integer return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return String return the rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * @param rue the rue to set
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * @return Integer return the codePostal
     */
    public Integer getCodePostal() {
        return codePostal;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * @return String return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

}
