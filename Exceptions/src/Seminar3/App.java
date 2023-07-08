package Seminar3;

import Seminar3.appPacket.UserData;
import Seminar3.appPacket.UserData_IO;
import Seminar3.appPacket.UserInput;
import Seminar3.exception.InterruptApp;
import Seminar3.exception.InvalidUserDataException;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        while (true) {
            try {
                // Считывание данных пользователя из консоли
                UserData userData = UserInput.getUserDataFromConsole();

                // Формирование данных пользователя и запись в файл с выводом результата
                String resp = UserData_IO.writeUserDataToFile(userData);
                System.out.println(resp);


            } catch (InvalidUserDataException e) {
                // Возникли ошибки в формате ввода данных (программа не завершается)
                System.out.println("Ошибка: " + e.getMessage());

            } catch (InterruptApp e) {
                // Нормальное прерывание работы приложения
                // код возврата 0
                System.out.println("Программа завершена. Удачи!");
                System.exit(0);

            } catch (IOException e) {
                // Прерывание работы приложения из-за ошибок ввода/вывода
                // вывод stackTrace и выход
                // код возврата 1
                System.out.println("Ошибка ввода/вывода");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}