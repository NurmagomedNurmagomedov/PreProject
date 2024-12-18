package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable(); // созддать таблицу
//
//        userService.saveUser("Нурмагомед", "Нурмагомедов", (byte) 46);
//        userService.saveUser("Шамиль", "Нурмагомедов", (byte) 18);
//        userService.saveUser("Амина", "Нурмагомедова", (byte) 14);
//        userService.saveUser("Напи", "Нурмагомедова", (byte) 39);
//
//        for (User user : userService.getAllUsers()) { // Вывести список всех пользователей
//            System.out.println(user);
//        }

//        userService.removeUserById(1); // Удаление пользователя с Ид 1
//
//        for (User user : userService.getAllUsers()) { // Вывести список всех пользователей
//            System.out.println(user);
//        }
//
//        userService.cleanUsersTable(); //удаление всех пользователей из таблицы
//
//        userService.dropUsersTable(); //удалить таблицу

//        ========================== Hibernate ========================================


//        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
//
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        Session session = sessionFactory.getCurrentSession();
//
//        User user;
//        try {
//            session.beginTransaction();
//            user = session.get(User.class, 2L);
//            session.getTransaction().commit();
//        } finally {
//            session.close();
//        }
       UserDao userDao = new UserDaoHibernateImpl();
//
//        for (User user : userDao.getAllUsers()) {
//            System.out.println(user);
//        }

        userDao.saveUser("Нурик", "Нурик", (byte) 19);


//        System.out.println(user);
        // реализуйте алгоритм здесь
    }
}
