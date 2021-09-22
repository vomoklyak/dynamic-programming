package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxSumSubArrayKadaneSearch {

    public static int search(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int value : array) {
            currentSum = currentSum + value;
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(0, currentSum);
        }
        return maxSum;
    }

}
