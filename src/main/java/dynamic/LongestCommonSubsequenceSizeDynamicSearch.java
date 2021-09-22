package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestCommonSubsequenceSizeDynamicSearch {

    public static void main(String[] args) {
        System.out.println(search("123", "1112"));
    }

    public static int search(String left, String right) {
        valid(left, right);
        int[][] subsequences = new int[left.length() + 1][right.length() + 1];
        // row left char index
        for (int row = 0; row <= left.length(); row++) {
            subsequences[row][0] = 0;
        }
        // column right char index
        for (int column = 0; column <= right.length(); column++) {
            subsequences[0][column] = 0;
        }
        for (int row = 1; row <= left.length(); row++) {
            for (int column = 1; column <= right.length(); column++) {
                if (left.charAt(row - 1) == right.charAt(column - 1)) {
                    subsequences[row][column] = subsequences[row - 1][column - 1] + 1;
                } else {
                    subsequences[row][column] =
                            Math.max(subsequences[row - 1][column], subsequences[row][column - 1]);
                }
            }
        }
        return subsequences[left.length()][right.length()];
    }

    private static void valid(String left, String right) {
        if (left == null) {
            throw new IllegalArgumentException("Parameter left cannot be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("Parameter right cannot be null");
        }
    }

}
