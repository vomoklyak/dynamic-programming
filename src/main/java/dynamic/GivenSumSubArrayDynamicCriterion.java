package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GivenSumSubArrayDynamicCriterion {

    public static boolean check(int[] array, int sum) {
        valid(array, sum);
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
        return sums[array.length - 1][sum];
    }

    private static void valid(int[] array, int sum) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter array cannot be null");
        }
        if (sum < 0) {
            throw new IllegalArgumentException("Parameter sum cannot be negative");
        }
    }

}