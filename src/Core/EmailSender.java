package Core;

import Business.abstracts.EmailSenderService;
import Entities.concretes.User;

public class EmailSender implements EmailSenderService {

    String verifyCode;

    @Override
    public String toProduceCode(User user) {
        this.verifyCode = String.valueOf(user.getId()+user.getEmail());
        return verifyCode;
    }

    @Override
    public void sendMail(User user) {
        System.out.println("Sayın " + user.getFirstName() + " " + user.getLastName() + " hesabınıza bir doğrulama emaili gönderildi. " + verifyCode);
    }

    @Override
    public boolean certifyCode(String code) {
        if(this.userCheck()) {
            if(this.verifyCode ==code) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean userCheck() {
        return true;
    }
}
