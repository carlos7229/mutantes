package com.marvel.mutantes.services;

import com.marvel.mutantes.DTO.Stats;
import com.marvel.mutantes.DTO.VerificacionDNA;
import com.marvel.mutantes.models.ADNModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvel.mutantes.repositories.ADNRepository;

@Service
public class VerificacionADNService {
    @Autowired
    ADNRepository verificacionADNRepository;

    public String getStats() {
        long total = verificacionADNRepository.count();
        long mutantes = verificacionADNRepository.countByEsMutante(true);
        double ratio = total > 0 ? ((double) mutantes / total) : 0;

       Stats stats = new Stats(mutantes,(total - mutantes), ratio);
       return stats.toString();
    }

    public ADNModel verificacionADN(VerificacionDNA dna) {
        
        boolean esMutante = verrificarADN(dna);
        StringBuilder builder = new StringBuilder();
        for(String strDna : dna.getDna()) {
            builder.append(strDna  + " ");
        }

        ADNModel verificacionADN = new ADNModel(builder.toString().trim(), esMutante);
        return saveVerificacionADN(verificacionADN);
    }

    public ADNModel saveVerificacionADN(ADNModel verificacionADN) {
        return verificacionADNRepository.save(verificacionADN);
    }

    private boolean verrificarADN(VerificacionDNA dnaModel){
        boolean isMutant = false;
        String[] dna = dnaModel.getDna();

        int contadorHorizontal = 0;
        int contadorDiagonal = 0;
        int contadorOblicuo = 0;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                if (j < dna[i].length() - 3) {
                    if (dna[i].charAt(j) == dna[i].charAt(j + 1) && dna[i].charAt(j) == dna[i].charAt(j + 2) && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                        contadorHorizontal++;
                    }
                }
                if (i < dna.length - 3) {
                    if (dna[i].charAt(j) == dna[i + 1].charAt(j) && dna[i].charAt(j) == dna[i + 2].charAt(j) && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                        contadorDiagonal++;
                    }
                }
                if (i < dna.length - 3 && j < dna[i].length() - 3) {
                    if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) && dna[i].charAt(j) == dna[i + 2].charAt(j + 2) && dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                        contadorOblicuo++;
                    }
                }
                if (i > 2 && j < dna[i].length() - 3) {
                    if (dna[i].charAt(j) == dna[i - 1].charAt(j + 1) && dna[i].charAt(j) == dna[i - 2].charAt(j + 2) && dna[i].charAt(j) == dna[i - 3].charAt(j + 3)) {
                        contadorOblicuo++;
                    }
                }
            }
        }

        if (contadorHorizontal > 0 || contadorDiagonal > 0 || contadorOblicuo > 0) {
            isMutant = true;
        }        

        return isMutant;
    }
}
