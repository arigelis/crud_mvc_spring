package testgroup.crud.dao;

import testgroup.crud.model.User;

import java.util.List;

public interface UserDAO {
    List allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(long id);
}