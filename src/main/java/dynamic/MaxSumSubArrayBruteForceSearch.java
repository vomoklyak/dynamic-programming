package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxSumSubArrayBruteForceSearch {

    public static int search(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int maxSum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int index = 0; index < array.length; index++) {
            int sum = array[index];
            maxElement = Math.max(maxElement, array[index]);
            for (int subIndex = index + 1; subIndex < array.length; subIndex++) {
                log.trace("Sub array start index: {}, end index {}, sum {}", index, subIndex, sum);
                sum += array[subIndex];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum == 0 ? maxElement : maxSum;
    }

}