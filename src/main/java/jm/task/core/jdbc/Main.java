package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {


//        ========================== JDBC ========================================
//        UserService userService = new UserServiceImpl();
//
//        // созддать таблицу
//        userService.createUsersTable();
//
//        // Добавление пользователей
//        userService.saveUser("Елена", "Заярная", (byte) 18);
//        userService.saveUser("Нурмагомед", "Нурмагомедов", (byte) 46);
//        userService.saveUser("Михаил", "Юриков", (byte) 19);
//        userService.saveUser("Артур", "Каныбеков", (byte) 26);
//        userService.saveUser("Вячеслав", "Калиновский", (byte) 18);
//
//        // Вывести всех пользователей
//        for (User user : userService.getAllUsers()) { // Вывести список всех пользователей
//            System.out.println(user);
//        }
//
//        // Уддаление пользователя с Id 2
//        userService.removeUserById(2);
//
//        //удаление всех пользователей из таблицы
//        userService.cleanUsersTable();
//
//        //удалить таблицу
//        userService.dropUsersTable();

//        ========================== Hibernate ========================================

        UserDao userDao = new UserDaoHibernateImpl();

        // Создание таблицы
        userDao.createUsersTable();

        // Добавление пользователей
        userDao.saveUser("Елена", "Заярная", (byte) 18);
        userDao.saveUser("Нурмагомед", "Нурмагомедов", (byte) 46);
        userDao.saveUser("Михаил", "Юриков", (byte) 19);
        userDao.saveUser("Артур", "Каныбеков", (byte) 26);
        userDao.saveUser("Вячеслав", "Калиновский", (byte) 18);

        // Вывести всех пользователей
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }

        // Уддаление пользователя с Id
        userDao.removeUserById(2);

        //удаление всех пользователей из таблицы
        userDao.cleanUsersTable();

        //удалить таблицу
        userDao.dropUsersTable();
    }
}
