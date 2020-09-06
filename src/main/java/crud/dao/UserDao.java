package crud.dao;

import crud.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
