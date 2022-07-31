package com.marvel.mutantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marvel.mutantes.models.ADNModel;

@Repository
public interface ADNRepository extends CrudRepository<ADNModel, Long> {

    long countByEsMutante(boolean b);
    
}
