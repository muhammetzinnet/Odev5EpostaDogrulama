package Business.concretes;

import Business.abstracts.UserService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao){
        super();
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
        System.out.println("Kişi eklendi");
        return;
    }

    @Override
    public List<User> getAll() {
        userDao.getAll();
        return userDao.getAll();
    }

}
