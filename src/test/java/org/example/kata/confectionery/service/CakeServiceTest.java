package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.model.Cake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CakeServiceTest {

    @Autowired
    private ICakeService service;

    @Test
    void when_get_cake_with_existing_id_then_return_cake() {
        Cake cake = this.service.getCake(1L);

        assertNotNull(cake);
        assertEquals(1L, cake.getId());
    }

}
