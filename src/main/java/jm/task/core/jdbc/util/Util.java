package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // Константы для подключения к базе данных
    private static String URL;// = "jdbc:postgresql://localhost:5432/PreProject";
    private static String USERNAME;// = "preproject"; // имя пользователя
    private static String PASSWORD;// = "123"; // пароль

    static {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
            // Загрузка драйвера PostgreSQL
            Properties properties = new Properties();
            properties.load(input);
            URL = properties.getProperty("hibernate.connection.url");
            USERNAME = properties.getProperty("hibernate.connection.username");
            PASSWORD = properties.getProperty("hibernate.connection.password");
            Class.forName(properties.getProperty("hibernate.driver_class"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Не удалось загрузить драйвер PostgreSQL", e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Не найден файл с настройками подключения JDBC \"Hibernate.properties\"", e);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла с настройками подключения JDBC \"Hibernate.properties\"", e);
        }
    }

    private Util() {
    }

    public static Connection getConnection() {
        Connection connection = null; // Получение значений по ключам
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Ошибка подключения (JDBC) к базе данных: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static Session getSession() {
        Session session = null;
        try {
            Configuration configuration = new Configuration().addAnnotatedClass(User.class);
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            System.err.println("Ошибка подключения (Hibernate) к базе данных: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return session;
    }
    // реализуйте настройку соеденения с БД
}
