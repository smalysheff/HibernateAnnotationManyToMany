package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Role;
import ru.sapteh.model.User;
import ru.sapteh.service.RoleService;
import ru.sapteh.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<User, Long> userService = new UserService(factory);
        DAO<Role, Long> roleService = new RoleService(factory);

        User user = new User();
        user.setFirstName("Nik");
        user.setLogin("nik");
        user.setPassword("1111");

        Role role = new Role();
        role.setRoleName("admin");

        Set<User> users = new HashSet<>();
        users.add(user);
        role.setUsers(users);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        userService.create((User) user);
        roleService.create((Role) role);


    }

}
