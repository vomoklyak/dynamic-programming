package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InterleavingStringRecursiveCriterion {

    public static boolean check(String left, String right, String interleaving) {
        if (left.length() + right.length() != interleaving.length()) {
            return false;
        }
        return check(left, 0, right, 0, interleaving);
    }

    private static boolean check(String left, int leftIndex, String right, int rightIndex, String interleaving) {
        log.trace("Check left index: {}, right index: {}", leftIndex, rightIndex);
        if (leftIndex + rightIndex == interleaving.length()) {
            return true;
        }
        int interleavingIndex = leftIndex + rightIndex;
        boolean leftSameChar = sameChar(left, leftIndex, interleaving, interleavingIndex);
        boolean rightSameChar = sameChar(right, rightIndex, interleaving, interleavingIndex);
        return (leftSameChar && check(left, leftIndex + 1, right, rightIndex, interleaving)) ||
                (rightSameChar && check(left, leftIndex, right, rightIndex + 1, interleaving));
    }

    private static boolean sameChar(String string, int index, String interleavingString, int interleavingIndex) {
        return index < string.length() &&
                string.charAt(index) == interleavingString.charAt(interleavingIndex);
    }

}