package ru.innopolis.java.test.homework06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Andrew", 2000);
    }

    @AfterEach
    void tearDown() {
        person = null;
    }

    @Test
    @DisplayName("Проверка правильности обработки введенного значения - имя")
    void getPersonName() {
        assertNotEquals("Maria", person.getPersonName());
        assertEquals("Andrew", person.getPersonName());
    }

    @Test
    @DisplayName("Проверка правильности установки нового значения - имя")
    void setPersonName() {
        person.setPersonName("Maria");
        assertEquals(person.getPersonName(),"Maria", "Name set should be equal to getPersonName");
        assertNotEquals(person.getPersonName(), "Andrew", "Name set should not be equal to getPersonName");
    }

    @Test
    @DisplayName("Проверка правильности обработки введенного значения - деньги покупателя")
    void getHasMoney() {
        assertNotEquals(1500, person.getHasMoney());
        assertEquals(2000, person.getHasMoney());
    }

    @Test
    @DisplayName("Проверка правильности установки нового значения - деньги покупателя")
    void setHasMoney() {
        person.setHasMoney(1500);
        assertEquals(person.getHasMoney(), 1500);
        assertNotEquals(person.getHasMoney(), 1600);
    }

    @Test
    @DisplayName("Проверка правильности установки нового значения - корзина покупателя")
    void testSetShoppingCart() {
        Product product1 = new Product("Tomato", 2000);
        Product product2 = new Product("Cucumber", 1500);
        List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));

        person.setShoppingCart(products);

        List<Product> shoppingCartProducts = person.getShoppingCart();
        assertEquals(2, shoppingCartProducts.size());
        assertTrue(shoppingCartProducts.contains(product1));
        assertTrue(shoppingCartProducts.contains(product2));
    }

    @Test
    @DisplayName("Проверка правильности обработки процедуры добавления товаров в корзину")
    void testAddToShoppingCart() {
        Product product = new Product("Tomato", 1500);
        person.addToShoppingCart(product);

        List<Product> products = person.getShoppingCart();
        assertEquals(1, products.size());
        assertEquals(product, products.get(0));
        assertEquals(500, person.getHasMoney());
    }
}