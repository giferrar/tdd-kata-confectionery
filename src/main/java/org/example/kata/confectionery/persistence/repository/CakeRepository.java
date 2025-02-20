package org.example.kata.confectionery.persistence.repository;

import org.example.kata.confectionery.persistence.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {
}
