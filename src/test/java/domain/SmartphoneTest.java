package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneTest {

    // проверка класса
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone Smartphone = new Smartphone();
    }

    // проверка хеша
    @Test
    public void shouldUseEquals() {
        Smartphone smartphone1 = new Smartphone(2, "A51", 10000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A51", 10000, "Samsung");
        assertEquals(smartphone1,smartphone2);
    }
}
