package kr.ac.jejunu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HallaProductDao extends ProductDao{
    @Override
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:81/exam_db?characterEncoding=utf-8", "exam", "qwer");
    }
}