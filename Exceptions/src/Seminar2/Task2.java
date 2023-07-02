package Seminar2;

import java.util.Arrays;

/*
Это какой-то бессмысленный код
9‑й элемент массива все время делится на 0, массив не определен, я не совсем понимаю, что именно нужно здесь исправить,
и какой нужно получить результат?

исправил так, как я это понял
* */
public class Task2 {
    public static void main(String[] args) {

//        Integer[] intArray = null;
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, null, 10};

        try {
            int d = 0;
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);

        } catch (NullPointerException e) {
            System.out.println("У вас NullPointerException: " + e + "\n>>> " + Arrays.toString(e.getStackTrace()));
        }
    }
}