package org.example.kata.confectionery.service;

import org.example.kata.confectionery.persistence.model.Cake;
import org.example.kata.confectionery.service.exception.CakeNotBakedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void when_find_cake_by_ingredients_with_existing_ingredient_then_return_cake() {
        List<Cake> cakes = this.service.findCakeByIngredientsContaining("savoiardi");

        assertNotNull(cakes);
        assertEquals(1, cakes.size());
        assertEquals("Tiramisu", cakes.get(0).getName());
    }

    @Test
    void when_find_cake_by_ingredients_with_non_existing_ingredient_then_return_empty_list() {
        List<Cake> cakes = this.service.findCakeByIngredientsContaining("nails");

        assertNotNull(cakes);
        assertTrue(cakes.isEmpty());
    }

    @Test
    void when_bake_cake_with_no_name_then_throw_exception() {
        Cake cake = new Cake();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> this.service.bakeCake(cake));

        assertEquals("Name is mandatory", exception.getMessage());
    }

    @Test
    void when_bake_cake_with_few_ingredients_then_throw_exception() {
        Cake cake = new Cake();
        cake.setName("Pumpkin Pie");
        cake.setIngredients("flour,sugar");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> this.service.bakeCake(cake));

        assertEquals("Not enough ingredients", exception.getMessage());
    }

    @Test
    void when_bake_cake_with_proper_ingredients_then_return_cake() {
        Cake cake = new Cake();
        cake.setName("Pumpkin Pie");
        cake.setIngredients("flour,sugar,egg,pumpkin");
        Cake persistedCake = assertDoesNotThrow(() -> this.service.bakeCake(cake));

        assertNotNull(persistedCake);
        assertNotNull(persistedCake.getId());
    }

    @Test
    void when_delete_cake_by_name_then_cake_is_deleted() {
        assertDoesNotThrow(() -> this.service.getCake(4L));
        this.service.deleteCakeByName("Strawberry Cake");
        assertThrows(CakeNotBakedException.class, () -> this.service.getCake(4L));
    }

    @Test
    void when_eat_cake_if_healthy_with_healthy_cake_then_return_calories() {
        int calories = assertDoesNotThrow(() -> this.service.eatCakeIfHealthy(5L));

        assertEquals(224, calories);
    }

    @Test
    void when_eat_cake_if_healthy_with_unhealthy_cake_then_return_zero() {
        int calories = assertDoesNotThrow(() -> this.service.eatCakeIfHealthy(2L));

        assertEquals(0, calories);
    }

}
