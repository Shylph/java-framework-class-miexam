package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDaoTest {
    @Before
    public void setup() {
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        Product product = new Product();
        product.setTitle("제주감귤");
        product.setPrice(15000);
        Long id = productDao.insert(product);

        Product insertedProduct = productDao.get(id);
        assertThat(insertedProduct.getId(), is(id));
        assertThat(insertedProduct.getTitle(), is(product.getTitle()));
        assertThat(insertedProduct.getPrice(), is(product.getPrice()));
    }
}
