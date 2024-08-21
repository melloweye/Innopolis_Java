package ru.innopolis.java.test.homework06;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private List<Person> people;
    private List<Product> products;

    @BeforeEach
    void setUp() {
        people = new ArrayList<>();
        products = new ArrayList<>();
    }
    @AfterEach
    void tearDown() {
        people.clear();
        products.clear();
    }

    @Test
    @DisplayName("Проверка корректности создания покупателя из введенной в консоль строки - ввод без ошибок")
    void testCreatePersonFromInput_ValidInput() {
        String input = "Andrew 10000";
        Person person = App.createPersonFromInput(input);
        assertNotNull(person);
        assertEquals("Andrew", person.getPersonName());
        assertEquals(10000, person.getHasMoney());
    }

    @Test
    @DisplayName("Проверка корректности создания товара из введенной в консоль строки - ввод без ошибок")
    void testCreateProductFromInput_ValidInput() {
        String input = "Tomato 5000";
        Product product = App.createProductFromInput(input);
        assertNotNull(product);
        assertEquals("Tomato", product.getName());
        assertEquals(5000, product.getPrice());
    }

    @Test
    @DisplayName("Проверка корректности отработки условия по выбору товаров покупателями")
    void testPurchaseProduct() {
        Person person = new Person("Andrew", 10000);
        Product product = new Product("Tomato", 5000);

        people.add(person);
        products.add(product);

        App.purchaseProduct(people, products, "Andrew - Tomato");

        assertEquals(5000, person.getHasMoney());
        assertEquals(1, person.getShoppingCart().size());
        assertEquals("Tomato", person.getShoppingCart().get(0).getName());
    }

    @Test
    @DisplayName("Проверка корректности создания покупателя из введенной в консоль строки. Ошибка - нет денег")
    void testCreatePersonFromInput_InvalidInput_NoMoney() {
        String input = "Andrew";
        assertThrows(IllegalArgumentException.class, () -> App.createPersonFromInput(input));
    }

    @Test
    @DisplayName("Проверка корректности создания товара из введенной в консоль строки. Ошибка - нет цены")
    void testCreateProductFromInput_InvalidInput_NoPrice() {
        String input = "Tomato";
        assertThrows(IllegalArgumentException.class, () -> App.createProductFromInput(input));
    }

    @Test
    @DisplayName("Проверка корректности создания товара из введенной в консоль строки. Ошибка - отрицательная стоимость")
    void testCreateProductFromInput_InvalidInput_NegativePrice() {
        String input = "Tomato -500";
        assertThrows(IllegalArgumentException.class, () -> App.createProductFromInput(input));
    }

    @Test
    @DisplayName("Проверка корректности создания покупателя из введенной в консоль строки. Ошибка - отрицательные деньги")
    void testCreatePersonFromInput_InvalidInput_NegativeMoney() {
        String input = "Andrew -1000";
        assertThrows(IllegalArgumentException.class, () -> App.createPersonFromInput(input));
    }

    @Test
    @DisplayName("Проверка валидности имени покупателя")
    void testValidatePersonName_ValidInput() {
        String input = "Andrew";
        assertDoesNotThrow(() -> App.validatePersonName(input));
    }

    @Test
    @DisplayName("Проверка валидности названия продукта")
    void testValidateProductName_ValidInput() {
        String input = "Tomato";
        assertDoesNotThrow(() -> App.validateProductName(input));
    }

    @Test
    @DisplayName("Обработка ошибки - пустое имя покупателя")
    void testValidatePersonName_EmptyName() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> App.validatePersonName(input));
    }

    @Test
    @DisplayName("Обработка ошибки - пустое название продукта")
    void testValidateProductName_EmptyName() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> App.validateProductName(input));
    }

    @ParameterizedTest
    @DisplayName("Тест с параметрами. Проверка исключения")
    @ValueSource(strings = {"Tomato", "Cucumber", "Potato"})
    void testValidateProductName_validInput(String productName) {
        // valid name doesn't throw exception
        assertDoesNotThrow(() -> App.validateProductName(productName));
    }

    @ParameterizedTest
    @DisplayName("Тест с параметрами. Проверка исключения")
    @ValueSource(strings = {""})
    void testValidatePersonName_emptyInput(String personName) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            App.validatePersonName(personName);
        });
        assertEquals("Имя не может быть пустым", exception.getMessage());
    }

    @Disabled("Тест отключен")
    @Test
    void testIgnoredTest() {
        // тест выполнен не будет
    }
}