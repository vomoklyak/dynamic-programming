package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestBitonicSubArraySizeDynamicSearch {

    public static int search(int[] array) {
        valid(array);
        // longest increasing sub array
        int[] lisa = lisa(array);
        // longest decreasing sub array
        int[] ldsa = ldsa(array);
        return IntStream.range(0, array.length)
                .map(index -> lisa[index] + ldsa[index] - 1)
                .max().orElse(0);
    }

    private static void valid(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter array cannot be null");
        }
    }

    private static int[] lisa(int[] array) {
        int[] lisa = new int[array.length];
        Arrays.fill(lisa, 1);
        for (int index = 1; index < array.length; index++) {
            for (int subIndex = 0; subIndex < array.length; subIndex++) {
                if (array[subIndex] < array[index] && lisa[index] < lisa[subIndex] + 1) {
                    lisa[index] = lisa[subIndex] + 1;
                }
            }
        }
        return lisa;
    }

    private static int[] ldsa(int[] array) {
        int[] ldsa = new int[array.length];
        Arrays.fill(ldsa, 1);
        for (int index = array.length - 2; index >= 0; index--) {
            for (int subIndex = array.length - 1; subIndex > index; subIndex--) {
                if (array[index] > array[subIndex] && ldsa[index] < ldsa[subIndex] + 1) {
                    ldsa[index] = ldsa[subIndex] + 1;
                }
            }
        }
        return ldsa;
    }

}
