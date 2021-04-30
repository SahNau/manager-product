package repository;

import domain.Product;
import Exception.NotFoundException;

import java.util.Arrays;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // найти по id
    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // выдать все объекты
    public Product[] getAll() {
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // удалить по id
    public void removeById(int id) {
        // пишем исключение: вызываем метод findById: если результат - null, тогда выкидывайте исключение NotFoundException
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductRepository that = (ProductRepository) o;
            return Arrays.equals(items, that.items);
        }

        @Override
        public int hashCode () {
            return Arrays.hashCode(items);
        }
    }

