package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestPalindromicSubstringSizeDynamicSearch {

    public static int search(String string) {
        valid(string);
        int rows = string.length() + 1;
        int columns = string.length() + 1;
        int[][] substringSizes = new int[rows][columns];
        // row: left string char index
        for (int row = rows - 2; row >= 0; row--) {
            // column: right string char index + 1
            for (int column = row + 1; column < columns; column++) {
                if (row == column - 1) {
                    substringSizes[row][column] = 1;
                } else if (string.charAt(row) == string.charAt(column - 1)) {
                    substringSizes[row][column] = (2 + substringSizes[row + 1][column - 1]);
                } else {
                    substringSizes[row][column] = Math.max(
                            substringSizes[row + 1][column], substringSizes[row][column - 1]);
                }
            }
        }
        return substringSizes[0][string.length()];
    }

    private static void valid(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Parameter string cannot be null");
        }
    }

}