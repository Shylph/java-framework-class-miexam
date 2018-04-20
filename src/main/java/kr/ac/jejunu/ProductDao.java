package kr.ac.jejunu;

import java.sql.SQLException;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws SQLException {
        StatementStrategy strategy = new GetStatementStrategy(id);
        return jdbcContext.ContextForGet(strategy);
    }


    public Long insert(Product product) throws SQLException {
        StatementStrategy strategy = new InsertStatementStrategy(product);
        return jdbcContext.ContextForInsert(strategy);
    }


    public void delete(Long id) throws SQLException {
        StatementStrategy strategy = new DeleteStatementStrategy(id);
        jdbcContext.ContextForUpdate(strategy);

    }


    public void update(Product product) throws SQLException {
        StatementStrategy strategy = new UpdateStatementStrategy(product);
        jdbcContext.ContextForUpdate(strategy);
    }
}

