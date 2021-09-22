package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InterleavingStringDynamicCriterion {

    public static boolean check(String left, String right, String interleaving) {
        if (left.length() + right.length() != interleaving.length()) {
            return false;
        }
        int leftLength = left.length();
        int rightLength = right.length();
        boolean[][] interleavings = new boolean[leftLength + 1][rightLength + 1];
        interleavings[0][0] = true;
        // row left string char index
        for (int row = 1; row <= leftLength; row++) {
            interleavings[row][0] = interleavings[row - 1][0] &&
                    left.charAt(row - 1) == interleaving.charAt(row - 1);
        }
        // row right string char index
        for (int column = 1; column <= rightLength; column++) {
            interleavings[0][column] = interleavings[0][column - 1] &&
                    right.charAt(column - 1) == interleaving.charAt(column - 1);
        }
        for (int row = 1; row <= leftLength; row++) {
            for (int column = 1; column <= rightLength; column++) {
                boolean leftSameChar = left.charAt(row - 1) == interleaving.charAt(row + column - 1);
                boolean rightSameChar = right.charAt(column - 1) == interleaving.charAt(row + column - 1);
                if (leftSameChar && !rightSameChar) {
                    interleavings[row][column] = interleavings[row - 1][column];
                } else if (!leftSameChar && rightSameChar) {
                    interleavings[row][column] = interleavings[row][column - 1];
                } else if (leftSameChar && rightSameChar) {
                    interleavings[row][column] = interleavings[row - 1][column] || interleavings[row][column - 1];
                }
            }
        }
        return interleavings[leftLength][rightLength];
    }

}