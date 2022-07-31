package com.marvel.mutantes.DTO;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class StatsTest {

    @Mock
    Stats stats;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        stats = new Stats(40, 100, 0.4);

    }

    @Test
    void testToString() {
        assertEquals("[mutants: 40, humans: 100, ratio: 0.4]", stats.toString());



    }
}