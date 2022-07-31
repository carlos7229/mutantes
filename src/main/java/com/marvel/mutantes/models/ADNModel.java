package com.marvel.mutantes.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adn")
public class ADNModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String dna;
    private boolean esMutante;

    public ADNModel(String dna, boolean esMutante) {
        this.dna = dna;
        this.esMutante = esMutante;    
    }
    public boolean getEsMutante() {
        return esMutante;
    }
}
