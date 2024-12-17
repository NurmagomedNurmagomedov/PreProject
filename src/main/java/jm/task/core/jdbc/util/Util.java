package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private Util() {
    }

    // Константы для подключения к базе данных
    private static final String URL = "jdbc:postgresql://localhost:5432/PreProject";
    private static final String USERNAME = "preproject"; // имя пользователя
    private static final String PASSWORD = "123"; // пароль

    static {
        try {
            // Загрузка драйвера PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Не удалось загрузить драйвер PostgreSQL", e);
        }
    }


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
    // реализуйте настройку соеденения с БД
}
