package Business.abstracts;

import Entities.concretes.User;

public interface EmailSenderService {
    String toProduceCode(User user);
    void sendMail(User user);
    boolean certifyCode(String code);
    boolean userCheck();
}
