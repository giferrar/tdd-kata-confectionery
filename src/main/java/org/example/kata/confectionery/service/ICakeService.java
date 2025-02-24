package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.model.Cake;

import java.util.List;

public interface ICakeService {
    Cake getCake(long l);

    List<Cake> findCakeByIngredientsContaining(String ingredient);

    Cake bakeCake(Cake cake);

    void deleteCakeByName(String strawberryCake);

    Integer eatCakeIfHealthy(long l);
}
