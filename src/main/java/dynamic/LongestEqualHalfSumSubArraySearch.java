package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestEqualHalfSumSubArraySearch {

    public static int search(int[] array) {
        int maxLength = 0;
        for (int index = 0; index < array.length; index++) {
            for (int subIndex = index + 1; subIndex < array.length; subIndex += 2) {
                log.trace("Process sub array start index:{}, end index:{}", index, subIndex);
                int subArrayLength = subIndex - index + 1;
                if (maxLength < subArrayLength && equalHalfSumArray(array, index, subIndex)) {
                    log.trace("Update max length: {}", subArrayLength);
                    maxLength = subArrayLength;
                }
            }
        }
        return maxLength;
    }

    private static boolean equalHalfSumArray(int[] array, int startIndex, int endIndex) {
        int leftSum = 0;
        int rightSum = 0;
        while (startIndex < endIndex) {
            leftSum += array[startIndex++];
            rightSum += array[endIndex--];
        }
        return leftSum == rightSum;
    }

}
