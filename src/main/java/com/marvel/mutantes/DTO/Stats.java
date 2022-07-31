package com.marvel.mutantes.DTO;

public class Stats {
    private final long count_mutant_dna;
    private final long count_human_dna;
    private final double ratio;

    public Stats(long mutants, long humans, double ratio) {
        this.count_mutant_dna = mutants;
        this.count_human_dna = humans;
        this.ratio = ratio;
    }

    public String toString() {
        return "[mutants: " + count_mutant_dna + ", humans: " + count_human_dna + ", ratio: " + ratio + "]";
    }
}