package DataAccess.concretes;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HipernateUserDao implements UserDao {

    List<User> users;

    {
        users = new ArrayList<User>();
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void delete(int id) {
        for(User member:users) {
            if(member.getId()==id) {
                users.remove(member);
                System.out.println("Kişi silindi");
            }
        }
    }

    @Override
    public void update(User user) {
        for(User member:users) {
            if(member.getId()==user.getId()) {
                member.setFirstName(user.getFirstName());
                member.setLastName(user.getLastName());
                member.setEmail(user.getEmail());
                member.setPassword(user.getPassword());
                System.out.println("Güncelleme başarılıdır.");
            }
        }
    }

    @Override
    public User get(int id) {
        User user = new User();
        for(User member:users){
            if(member.getId()==id){
                user = member;
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
