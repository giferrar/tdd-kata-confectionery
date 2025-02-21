package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.repository.CakeRepository;
import org.springframework.stereotype.Service;

@Service
public class CakeService implements ICakeService {

    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }


}
