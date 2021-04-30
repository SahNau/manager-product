package repository;

import domain.Smartphone;
import org.junit.jupiter.api.Test;
import domain.Product;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Smartphone coreJava = new Smartphone();
    Product first = new Smartphone(1, "12PRO", 15000, "Apple");
    Product second = new Smartphone(2, "10M", 11000, "Xiaomi");


    // проверка поиска 1 товара из всех
    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    //удалить товар по id
    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove = 1;
        // вызывать метод
        repository.removeById(idToRemove);

        Product[] expected = new Product[]{};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }


    // Проверка удаляет несуществующий ID и не выдает ошибку NotFoundException
    @Test
    public void removeByIdNonExistent() {
        assertThrows(Exception.class, ()->repository.removeById(6));
    }
}