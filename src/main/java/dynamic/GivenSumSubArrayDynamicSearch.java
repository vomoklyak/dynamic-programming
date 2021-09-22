package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GivenSumSubArrayDynamicSearch {

    public static Integer[] search(int[] array, int sum) {
        valid(array, sum);
        boolean[][] sums = sums(array, sum);
        return givenSumSubArray(array, sum, sums);
    }

    private static void valid(int[] array, int sum) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter array cannot be null");
        }
        if (sum < 0) {
            throw new IllegalArgumentException("Parameter sum cannot be negative");
        }
    }

    private static boolean[][] sums(int[] array, int sum) {
        boolean[][] sums = new boolean[array.length][sum + 1];
        // row array element
        for (int row = 0; row < array.length; row++) {
            sums[row][0] = true;
        }
        // column current sum
        for (int column = 1; column <= sum; column++) {
            sums[0][column] = column - array[0] == 0;
        }
        for (int row = 1; row < array.length; row++) {
            for (int column = 1; column <= sum; column++) {
                sums[row][column] = sums[row - 1][column];
                if (array[row] <= column) {
                    sums[row][column] |= sums[row - 1][column - array[row]];
                }
            }
        }
        return sums;
    }

    private static Integer[] givenSumSubArray(int[] array, int sum, boolean[][] sums) {
        List<Integer> subList = new ArrayList<>();
        if (sums[array.length - 1][sum]) {
            while (sum > 0) {
                for (int row = 0; row < array.length; row++) {
                    if (sums[row][sum]) {
                        subList.add(array[row]);
                        sum -= array[row];
                        break;
                    }
                }
            }
        }
        return subList.toArray(new Integer[0]);
    }

}