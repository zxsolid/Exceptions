package Seminar1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Для задания 1 и 2
        Integer[] A = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Integer[][] M = {
                {8, 7, 6, 5, 4, 3, 2, 1},
                {5, 1, 9, 1, 3, -3, -10, 4},
                {8, 7, 6, 5},
                {8, 7, 6, 5, 4, 3, 2, 7, 11},
                {1, 0, 6, 5, 4, 3, 2, 7}};
        for (Integer[] B: M) {
            try {
                System.out.println("A = " + Arrays.toString(A));
                System.out.println("B = " + Arrays.toString(B));
                System.out.println("A+B " + Arrays.toString(ArrayOperations.addition(A, B)));
                System.out.println("A/B " + Arrays.toString(ArrayOperations.division(A, B)));
                System.out.println("A-B " + Arrays.toString(ArrayOperations.subtraction(A, B)));
            }catch (Exception e){
                System.out.println(e.toString());
            }
            System.out.println("=================================");
        }}

    // Отдельно для задания со *
    public int[] divideArrays(int[] arr1, int[] arr2) throws RuntimeException {
        // Проверяем, что массивы имеют одинаковую длину
        if (arr1.length != arr2.length) {
            // Если массивы имеют разную длину, бросаем исключение RuntimeException
            throw new RuntimeException("Массивы должны быть одинаковой длины");
        }
        // Создаем новый массив для хранения результата деления
        int[] result = new int[arr1.length];
        // Выполняем деление элементов массивов A и B
        for (int i = 0; i < arr1.length; i++) {
            // Проверяем, что элемент arr2[i] не равен нулю, чтобы избежать деления на ноль
            if (arr2[i] == 0) {
                // Если arr2[i] равен нулю, бросаем исключение RuntimeException
                throw new RuntimeException("Нельзя делить на ноль");
            }
            result[i] = arr1[i] / arr2[i];
        }
        // Возвращаем результат
        return result;
    }
}