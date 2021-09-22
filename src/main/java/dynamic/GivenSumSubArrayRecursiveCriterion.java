package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GivenSumSubArrayRecursiveCriterion {

    public static boolean check(int[] array, int sum) {
        valid(array, sum);
        return check(0, array, sum);
    }

    public static boolean check(int index, int[] array, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index == array.length) {
            return false;
        }
        if (sum < array[index]) {
            return check(index + 1, array, sum);
        }
        return check(index + 1, array, sum) || check(index + 1, array, sum - array[index]);
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