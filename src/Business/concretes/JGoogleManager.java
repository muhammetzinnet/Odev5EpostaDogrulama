package Business.concretes;

import Entities.concretes.User;

public class JGoogleManager {
    public void registerWithGoogle(User user)
    {
        System.out.println("Google ile giriş yapıldı: " + user.getFirstName());
    }
}
