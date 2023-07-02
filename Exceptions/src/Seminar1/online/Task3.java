package Seminar1.online;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Task3 {
    static int[][] arr = new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
    };

    private static boolean isNotSquareArray(int[][] array) {
        int arrlen = arr.length;
        for (int i = 0; i < arrlen; i++) {
            if (array[i].length != arrlen) return true;
        }
        return false;
    }

    private static boolean isDataNotCorrect(int[][] array) {
        List<Integer> container = List.of(0, 1);
        return IntStream.range(0, array.length)
                .anyMatch(i -> IntStream.range(0, array.length)
                        .anyMatch(j -> !container.contains(array[i][j])));
    }

    private static int arrSumm(int[][] arr) {
        if (isNotSquareArray(arr)) throw new RuntimeException("Массив не квадратный");
        if (isDataNotCorrect(arr)) throw new RuntimeException("Данные не корректны");
        return Arrays.stream(arr)
                .mapToInt(ints -> Arrays
                        .stream(ints, 0, arr.length)
                        .sum()).sum();
    }

    public static void main(String[] args) {
        System.out.println(arrSumm(arr));
    }
}