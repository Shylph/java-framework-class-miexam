package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDaoTest {

    private ProductDao productDao;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        productDao = applicationContext.getBean("productDao",ProductDao.class);
    }

    @Test
    public void get() {

        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void insert() {
        Product product = new Product();
        product.setTitle("제주감귤");
        product.setPrice(15000);
        Long id = productDao.insert(product);

        Product insertedProduct = productDao.get(id);
        assertThat(insertedProduct.getId(), is(id));
        assertThat(insertedProduct.getTitle(), is(product.getTitle()));
        assertThat(insertedProduct.getPrice(), is(product.getPrice()));
    }

    @Test
    public void delete() {
        Product product = new Product();
        product.setTitle("제주감귤");
        product.setPrice(15000);
        Long id = productDao.insert(product);

        productDao.delete(id);

        Product insertedProduct = productDao.get(id);
        assertThat(insertedProduct, nullValue());
    }

    @Test
    public void update() {
        Product product = new Product();
        product.setTitle("제주감귤");
        product.setPrice(15000);
        Long id = productDao.insert(product);

        product.setId(id);
        product.setTitle("제주한라봉");
        product.setPrice(40000);
        productDao.update(product);

        Product updatedProduct = productDao.get(id);
        assertThat(updatedProduct.getId(), is(product.getId()));
        assertThat(updatedProduct.getTitle(), is(product.getTitle()));
        assertThat(updatedProduct.getPrice(), is(product.getPrice()));
    }
}
