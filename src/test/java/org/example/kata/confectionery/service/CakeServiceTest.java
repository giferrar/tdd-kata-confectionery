package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.model.Cake;
import org.example.kata.confectionery.service.exception.CakeNotBakedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void when_get_cake_with_non_existing_id_then_throw_exception() {
        assertThrows(CakeNotBakedException.class, () -> this.service.getCake(999L));
    }

}
