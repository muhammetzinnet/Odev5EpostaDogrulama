import Business.abstracts.AuthService;
import Business.abstracts.EmailSenderService;
import Business.abstracts.UserService;
import Business.concretes.AuthManager;
import Business.concretes.UserManager;
import Core.EmailSender;
import DataAccess.concretes.HipernateUserDao;
import Entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new HipernateUserDao());
        AuthService authService = new AuthManager(userService, new EmailSender());
        User user = new User(1,"mahmut","çevik","mmm@gmail.com","123456");
        authService.login("mmm@gmail.com","123456");
    }
}
