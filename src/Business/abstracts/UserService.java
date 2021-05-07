package Business.abstracts;

import Entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
}
