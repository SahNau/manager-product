package manager;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    // инициализируем переменные
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    //создаём объекты
    Product first = new Book(1, "Семь жизней", 1000, "Кинг");
    Product second = new Book(2, "Ведьмак", 900, "Кинг");
    Product third = new Smartphone(3, "XP", 800, "XP");
    Product fourth = new Smartphone(4, "Sony", 700, "Sony");
    Product fifth = new Smartphone(5, "Apple", 600, "Apple");

    // применяем объекты
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    // добавления продукта
    @Test
    public void addProduct() {
        manager.add(second);
        assertArrayEquals(new Product[]{second}, repository.getAll());
    }

    // поиск продукта по названию
    @Test
    void searchByName() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Ведьмак");
        assertArrayEquals(expected, actual);
    }

    // соответствие продукта запросу по названию
    @Test
    void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Ведьмак");
        assertArrayEquals(expected, actual);
    }

    // соответствие продукта запросу по автору
    @Test
    void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Ведьмак");
        assertArrayEquals(expected, actual);
    }

    // соответствие продукта запросу по производителя
    @Test
    void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    // соответствие продукта запросу по назв.телефона
    @Test
    void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("XP");
        assertArrayEquals(expected, actual);
    }

    //  поиск выбранных книг по автору
    @Test
    void searchAllByAuthor() {
        setUp();

        Product[] expected = new Product[]{second, first};
        Product[] actual = manager.searchBy("Кинг");
        assertArrayEquals(expected, actual);
    }

    //  Поиск всего, но без ответа, т.к "null"
    @Test
    void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }
}





