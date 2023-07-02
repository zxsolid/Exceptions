package Seminar2;
/*
здесь добавил варианты "отлова" ошибок в соответствии с их иерархией и немного расширил сообщения

в методе было прописано исключение FileNotFoundException, хотя там нет операция с файлами,
но может быть IOException или NullPointerException, - заменил

* */

import java.io.IOException;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!\n" + ex + '\n' + Arrays.toString(ex.getStackTrace()));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!\n" + ex + '\n' + Arrays.toString(ex.getStackTrace()));
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так... \n" + ex + '\n' + Arrays.toString(ex.getStackTrace()));
        }
    }

    public static void printSum(Integer a, Integer b) throws IOException, NullPointerException {
        System.out.println(a + b);
    }
}