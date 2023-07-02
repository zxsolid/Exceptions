package Seminar1;

// Класс для операций с массивами
// методы бросают исключения при возникновении ошибок
public class ArrayOperations {

    /**
     * Проверка допустимых размеров массива
     *
     * @param A - массив Integer[]
     * @param B - массив Integer[]
     */
    private static void checkArray(Integer[] A, Integer[] B) throws RuntimeException {
        //
        if (A == null || B == null) {
            throw new RuntimeException("один из массивов null");
        }
        // Проверяем допустимую длину массива
        if (A.length == 0 || B.length == 0) {
            throw new IllegalArgumentException("Размер одного из массивов равен нулю.");
        }
        // Проверяем, что массивы имеют одинаковую длину
        if (A.length != B.length) {
            // Если массивы имеют разную длину, бросаем исключение IllegalArgumentException
            throw new IllegalArgumentException("Размеры массивов не одинаковы");
        }
    }

    public static Integer[] addition(Integer[] A, Integer[] B) {
        checkArray(A, B);
        // Создаем новый массив для хранения результата сложения
        Integer[] K = new Integer[A.length];
        // Выполняем сложение элементов массивов A и B
        for (int i = 0; i < A.length; i++) {
            K[i] = A[i] + B[i];
        }
        // Возвращаем результат
        return K;
    }


    public static Integer[] division(Integer[] A, Integer[] B) {
        checkArray(A, B);
        // Создаем новый массив для хранения результата деления
        java.lang.Integer[] K = new java.lang.Integer[A.length];
        int i = 0;
        try {
            // Выполняем деление элементов массивов A и B
            for (i = 0; i < A.length; i++) {
                // Проверяем, что элемент B[i] не равен нолю, чтобы избежать деления на ноль
                K[i] = A[i] / B[i];
            }
        } catch (ArithmeticException e) {
            throw new RuntimeException("При выполнении операции произошло деление на ноль, " +
                    "B[" + i + "] = 0.");
        }
        // Возвращаем результат
        return K;
    }

    public static Integer[] subtraction(Integer[] A, Integer[] B) {
        checkArray(A, B);
        // Создаем новый массив для хранения результата вычитания
        Integer[] K = new Integer[A.length];
        // Выполняем вычитание элементов массивов A и B
        for (int i = 0; i < A.length; i++) {
            K[i] = A[i] - B[i];
        }
        // Возвращаем результат
        return K;
    }
}