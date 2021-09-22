package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestCommonSubsequenceSizeRecursiveSearch {

    public static int search(String left, String right) {
        valid(left, right);
        return search(left, left.length() - 1, right, right.length() - 1);
    }

    private static void valid(String left, String right) {
        if (left == null) {
            throw new IllegalArgumentException("Parameter left cannot be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("Parameter right cannot be null");
        }
    }

    private static int search(String left, int leftIndex, String right, int rightIndex) {
        if (leftIndex < 0 || rightIndex < 0) {
            return 0;
        }
        if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
            return 1 + search(left, leftIndex - 1, right, rightIndex - 1);
        }
        return Math.max(search(left, leftIndex - 1, right, rightIndex),
                search(left, leftIndex, right, rightIndex - 1));
    }

}