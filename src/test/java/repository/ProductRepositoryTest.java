package repository;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}