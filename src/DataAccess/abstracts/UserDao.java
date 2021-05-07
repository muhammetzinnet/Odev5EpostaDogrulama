package DataAccess.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(int id);
    void update(User user);

    User get(int id);
    List<User> getAll();
}
