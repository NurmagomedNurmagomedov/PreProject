package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable(); // созддать таблицу

        userService.saveUser("Нурмагомед", "Нурмагомедов", (byte) 46);
        userService.saveUser("Шамиль", "Нурмагомедов", (byte) 18);
        userService.saveUser("Амина", "Нурмагомедова", (byte) 14);
        userService.saveUser("Напи", "Нурмагомедова", (byte) 39);

        for (User user : userService.getAllUsers()) { // Вывести список всех пользователей
            System.out.println(user);
        }

        userService.removeUserById(1); // Удаление пользователя с Ид 1

        for (User user : userService.getAllUsers()) { // Вывести список всех пользователей
            System.out.println(user);
        }

        userService.cleanUsersTable(); //удаление всех пользователей из таблицы

        userService.dropUsersTable(); //удалить таблицу

        // реализуйте алгоритм здесь
    }
}
