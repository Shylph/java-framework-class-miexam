package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws SQLException {
        StatementStrategy strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.ContextForGet(strategy);
    }


    public Long insert(Product product) throws SQLException {
        StatementStrategy strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(title,price) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setLong(2, product.getPrice());
            return preparedStatement;
        };
        return jdbcContext.ContextForInsert(strategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        jdbcContext.ContextForUpdate(strategy);
    }


    public void update(Product product) throws SQLException {
        StatementStrategy strategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set title=?, price=? where id=?");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setLong(3, product.getId());
            return preparedStatement;
        };
        jdbcContext.ContextForUpdate(strategy);
    }
}

