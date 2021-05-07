package Business.abstracts;

import Entities.concretes.User;

public interface AuthService {
    void login(String email, String password);
    void register(User user);
}
