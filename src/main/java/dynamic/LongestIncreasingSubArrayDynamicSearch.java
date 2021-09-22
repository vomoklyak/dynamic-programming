package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestIncreasingSubArrayDynamicSearch {

    public static int[] search(int[] array) {
        valid(array);
        int[] subArrays = new int[array.length];
        int[] subArrayLengths = IntStream.range(0, array.length).map(index -> 1).toArray();
        for (int index = 1; index < array.length; index++) {
            for (int subIndex = 0; subIndex < index; subIndex++) {
                int subArrayLength = subArrayLengths[subIndex] + 1;
                if (array[subIndex] < array[index] && subArrayLength > subArrayLengths[index]) {
                    subArrays[index] = subIndex;
                    subArrayLengths[index] = subArrayLength;
                }
            }
        }
        return longestIncreasingSubArray(array, subArrays, subArrayLengths);
    }

    private static void valid(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter array cannot be null");
        }
    }

    private static int[] longestIncreasingSubArray(int[] array, int[] subArrays, int[] subArrayLengths) {
        int index = maxSubArrayLengthIndex(subArrayLengths);
        int longestIncreasingSubArrayIndex = subArrayLengths[index] - 1;
        int[] longestIncreasingSubArray = new int[subArrayLengths[index]];
        while (subArrays[index] != index) {
            longestIncreasingSubArray[longestIncreasingSubArrayIndex--] = array[index];
            index = subArrays[index];
        }
        longestIncreasingSubArray[longestIncreasingSubArrayIndex] = array[index];
        return longestIncreasingSubArray;
    }

    private static int maxSubArrayLengthIndex(int[] subArrayLengths) {
        int maxSubArrayLength = 0;
        int maxSubArrayLengthIndex = 0;
        for (int index = 0; index < subArrayLengths.length; index++) {
            if (maxSubArrayLength < subArrayLengths[index]) {
                maxSubArrayLength = subArrayLengths[index];
                maxSubArrayLengthIndex = index;
            }
        }
        return maxSubArrayLengthIndex;
    }

}
