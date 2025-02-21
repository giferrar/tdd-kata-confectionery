package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.model.Cake;
import org.example.kata.confectionery.persistence.repository.CakeRepository;
import org.example.kata.confectionery.service.exception.CakeNotBakedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService implements ICakeService {

    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }


    @Override
    public Cake getCake(long id) {
        return cakeRepository.findById(id).orElseThrow(() -> new CakeNotBakedException("Cake with ID %s not baked".formatted(id)));
    }

    @Override
    public List<Cake> findCakeByIngredientsContaining(String ingredient) {
        return cakeRepository.findAllByIngredientsContaining(ingredient);
    }

    @Override
    public void bakeCake(Cake cake) {
        if (cake.getName() == null || cake.getName().isEmpty()) {
            throw new RuntimeException("Name is mandatory");
        }
        if (cake.getIngredients() == null || cake.getIngredients().isEmpty() || cake.getIngredients().split(",").length <= 3) {
            throw new RuntimeException("Not enough ingredients");
        }
    }
}
