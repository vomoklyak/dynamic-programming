package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestIncreasingSubArraySizeRecursiveSearch {

    public static int search(int[] array) {
        valid(array);
        return array.length == 0 ? 0 : search(array, 1, 0);
    }

    private static void valid(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Parameter array cannot be null");
        }
    }

    public static int search(int[] array, int index, int prevIndex) {
        if (index == array.length) {
            return 1;
        }
        int withoutCurrentElement = search(array, index + 1, prevIndex);
        int withCurrentElement = array[prevIndex] < array[index] ? search(array, index + 1, index) + 1 : 0;
        return Math.max(withCurrentElement, withoutCurrentElement);
    }

}
