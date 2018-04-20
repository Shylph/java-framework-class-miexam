package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class DaoFactory {

    @Bean
    public ProductDao productDao() {
        return new ProductDao(connectionMaker());
    }

    @Bean
    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
