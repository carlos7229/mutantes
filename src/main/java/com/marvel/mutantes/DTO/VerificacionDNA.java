package com.marvel.mutantes.DTO;

public class VerificacionDNA {
    public String[] dna;

    public VerificacionDNA() {
    }

    public VerificacionDNA(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
