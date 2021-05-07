package Core;

import Entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Control {
    public static boolean checkPassword(String password) {

        if(password.length()<6) {
            System.out.println("Şifreniz altı karakterden az olamaz.");
            return false;
        }else {
            System.out.println("Şifre başarılı.");
            return true;
        }

    }


    public static boolean checkEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()) {
            //System.out.println("check mail");
            return true;
        }else {

            return false;
        }
    }


    public static boolean checkName(String name) {
        if(name.length()<2) {
            System.out.println("İsminiz en az iki karakterli olmalıdır.");
            return false;
        }else {

            return true;
        }
    }


    public static boolean checkUserExists(List<User> users, String email) {

        for(User user:users) {
            if (user.getEmail() == email)

                return false;
        }

        return true;
    }

    public static boolean checkUserPassword(List<User> users, String password) {

        for(User user:users) {
            if (user.getPassword() == password)
                return true;
        }
        return false;
    }
}
