package com.marvel.mutantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.marvel.mutantes.DTO.VerificacionDNA;
import com.marvel.mutantes.models.ADNModel;
import com.marvel.mutantes.services.VerificacionADNService;

@RestController
@RequestMapping("/")
public class ADNController {
    @Autowired
    private VerificacionADNService verificacionADNService;

    @GetMapping("/stats")
    public String getStats() {
        return verificacionADNService.getStats();
    }

    @PostMapping("/mutant")
    public ResponseEntity<?> verificacionADN(@RequestBody VerificacionDNA dna) {
        ADNModel response = verificacionADNService.verificacionADN(dna);
        return ResponseEntity.status(response.getEsMutante() ? HttpStatus.OK : HttpStatus.FORBIDDEN).body(response);
    }

    
}
