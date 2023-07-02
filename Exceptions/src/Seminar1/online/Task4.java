package Seminar1.online;

import java.util.Scanner;

public class Task4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Введите логин:");
        String login = sc.nextLine();
        System.out.print("Введите пароль:");
        String password = sc.nextLine();
        System.out.print("Повторите пароль:");
        String confirm = sc.nextLine();
        if(check(login,password,confirm)){
            System.out.println("Вы зарегистрировались");
        }
    }

    private static boolean check(String login,
                                 String password,
                                 String confirm){
        return isLoginValid(login)&&
                isPasswordValid(password)&&
                isPasswordEquals(password,confirm);
    }

    private static boolean isLoginValid(String login) {
        if (!login.matches("[abcde01_]{4,8}")) {
            throw new RuntimeException("Логин должен содержать только символы: a, b, c, d, e, 0, 1, _ и быть длиной от 4 до 8 символов!");
        }
        return true;
    }

    private static boolean isPasswordValid(String password){
        if (!password.matches("\\d{4,8}")) {
            throw new RuntimeException("Пароль должен состоять только из цифр и быть длиной от 4 до 8 символов!");
        }
        return true;
    }

    private static boolean isPasswordEquals(String password, String cobfirm){
        if (!password.equals((cobfirm))){
            throw new RuntimeException("Пароль и повтор должны совпадать");
        }
        return true;
    }
}