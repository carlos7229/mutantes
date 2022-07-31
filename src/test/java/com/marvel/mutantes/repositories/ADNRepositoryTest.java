package com.marvel.mutantes.repositories;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;

class ADNRepositoryTest {

    @Mock
    ADNRepository adnRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void countByEsMutante() {
        when(adnRepository.countByEsMutante(true)).thenReturn((long) 1);
        when(adnRepository.countByEsMutante(false)).thenReturn((long) 0);
        assertNotNull(adnRepository.countByEsMutante(true));
    }
}