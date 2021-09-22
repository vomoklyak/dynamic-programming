package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BubbleSort {

    public static void sort(int[] array) {
        for (int index = 0; index < array.length; index++) {
            for (int subIndex = 0; subIndex < array.length - index - 1; subIndex++) {
                if (array[subIndex] > array[subIndex + 1]) {
                    int value = array[subIndex];
                    array[subIndex] = array[subIndex + 1];
                    array[subIndex + 1] = value;
                }
            }
        }
    }

    public static void recursiveSort(int[] array) {
        recursiveSort(array, array.length);
    }

    public static void recursiveSort(int[] array, int length) {
        for (int index = 0; index < length - 1; index++) {
            if (array[index] > array[index + 1]) {
                int value = array[index];
                array[index] = array[index + 1];
                array[index + 1] = value;
            }
        }
        if (length > 2) {
            recursiveSort(array, length - 1);
        }
    }

}
