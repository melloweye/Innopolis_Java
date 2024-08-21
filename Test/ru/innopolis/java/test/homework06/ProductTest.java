package ru.innopolis.java.test.homework06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Tomato", 150);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Test
    @DisplayName("Проверка правильности обработки введенного значения - название товара")
    void getName() {
        assertEquals("Tomato", product.getName());
        assertNotEquals("Cucumber", product.getName());
    }

    @Test
    @DisplayName("Проверка правильности установки нового значения - название товара")
    void setName() {
        product.setName("Tomato");
        assertEquals("Tomato", product.getName());
        assertNotEquals("Cucumber", product.getName());
    }

    @Test
    @DisplayName("Проверка правильности обработки введенного значения - стоимость товара")
    void getPrice() {
        assertEquals(150, product.getPrice());
        assertNotEquals(0, product.getPrice());
    }

    @Test
    @DisplayName("Проверка правильности установки нового значения - стоимость товара")
    void setPrice() {
        product.setPrice(150);
        assertEquals(150, product.getPrice());
        assertNotEquals(0, product.getPrice());
    }
}