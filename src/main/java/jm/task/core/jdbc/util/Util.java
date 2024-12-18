package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
