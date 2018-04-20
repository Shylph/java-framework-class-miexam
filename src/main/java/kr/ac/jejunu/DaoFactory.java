package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.Driver;

@Controller
public class DaoFactory {

    @Bean
    public ProductDao productDao() throws ClassNotFoundException {
        return new ProductDao(jdbcContext());
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        return new JdbcContext(dataSource());
    }

    @Bean
    private DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName("com.mysql.jdbc.Driver"));
        dataSource.setUrl("jdbc:mysql://localhost:81/exam_db?characterEncoding=utf-8");
        dataSource.setUsername("exam");
        dataSource.setPassword("qwer");
        return dataSource;
    }

}
