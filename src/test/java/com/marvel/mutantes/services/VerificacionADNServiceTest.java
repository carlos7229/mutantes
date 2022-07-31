package com.marvel.mutantes.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.marvel.mutantes.DTO.Stats;
import com.marvel.mutantes.DTO.VerificacionDNA;
import com.marvel.mutantes.models.ADNModel;
import com.marvel.mutantes.repositories.ADNRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;


import org.junit.jupiter.api.BeforeEach;

class VerificacionADNServiceTest {

    @Mock
    ADNModel adnModel;
    
    @Mock
    ADNRepository adnRepository;

    @Mock
    VerificacionDNA verificacionADN;

    @Mock
    private VerificacionADNService verificacionADNService;

    private Stats stats;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        adnModel = new ADNModel("ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG", true);
        stats = new Stats(1, 0, 0.0);
        verificacionADN = new VerificacionDNA(new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" });

    }

    @Test
    void getStats() {
        doReturn(stats.toString()).when(verificacionADNService).getStats();
        assertNotNull(verificacionADNService.getStats());
    }

    @Test
    void verificacionADN() {
        doReturn(adnModel).when(verificacionADNService).verificacionADN(verificacionADN);
        assertNotNull(verificacionADNService.verificacionADN(verificacionADN));
    }
}