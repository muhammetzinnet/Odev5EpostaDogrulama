package Business.concretes;

import Business.abstracts.AuthService;
import Business.abstracts.EmailSenderService;
import Business.abstracts.UserService;
import Core.Control;
import Entities.concretes.User;

public class AuthManager implements AuthService {

    private UserService userService;
    private EmailSenderService emailSenderService;

    public AuthManager(UserService userService, EmailSenderService emailSenderService){
        super();
        this.userService = userService;
        this.emailSenderService = emailSenderService;
    }
    @Override
    public void login(String email, String password) {
        if (!Control.checkUserExists(userService.getAll(),email)) {
            if(Control.checkUserPassword(userService.getAll(), password)) {
                System.out.println("Giriş başarılı");
                return;
            }
        }
        System.out.println("Girdiğiniz eposta sistemde kayıtlı değil. Lütfen kayıt olun.");
    }

    @Override
    public void register(User user) {
        if(Control.checkUserExists(userService.getAll(),user.getEmail())) {
            if(Control.checkName(user.getEmail())) {
                if(Control.checkEmail(user.getEmail())) {
                    if(Control.checkPassword(user.getPassword())) {
                        String code= emailSenderService.toProduceCode(user);
                        emailSenderService.sendMail(user);
                        if(emailSenderService.certifyCode(code)) {
                            userService.add(user);
                        }

                    }
                }
            }
        }else {
            System.out.println("Böyle bir kullanıcı zaten var.");
        }
    }
}



