package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    // проверка класса
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    // проверка хеша
    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(2, "Оно", 1000, "Кинг");
        Book book2 = new Book(2, "Оно", 1000, "Кинг");
        assertEquals(book1,book2);
    }
}