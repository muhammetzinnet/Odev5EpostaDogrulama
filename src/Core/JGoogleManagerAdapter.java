package Core;

import Business.abstracts.AuthService;
import Business.abstracts.UserService;
import Business.concretes.JGoogleManager;
import Entities.concretes.User;

public class JGoogleManagerAdapter implements AuthService {

    private UserService userService;

    public JGoogleManagerAdapter(UserService userService) {
        super();
        this.userService = userService;
    }

    @Override
    public void login(String email, String password) {
        if (!Control.checkUserExists(userService.getAll(),email)) {
            if(Control.checkUserPassword(userService.getAll(),password)) {
                System.out.println("Sisteme giris yapildi.");
                return;
            }
        }
        System.out.println("Email mevcut değil. Kayıt olun");
    }

    @Override
    public void register(User user) {

        if(Control.checkUserExists(userService.getAll(),user.getEmail())) {
            if(Control.checkName(user.getFirstName())) {
                if(Control.checkEmail(user.getEmail())) {
                    if(Control.checkPassword(user.getPassword())) {
                        JGoogleManager googleManager = new JGoogleManager();
                        googleManager.registerWithGoogle(user);
                    }
                }
            }
        }else {
            System.out.println("Kaydýnýz zaten mevcuttur.");
        }

    }
}
