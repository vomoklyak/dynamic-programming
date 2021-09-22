package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongestCommonSubsequenceDynamicSearch {

    public static Optional<String> search(String left, String right) {
        valid(left, right);
        int[][] subsequences = subsequences(left, right);
        return longestCommonSubsequence(left, right, subsequences);
    }

    public static int[][] subsequences(String left, String right) {
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
        return subsequences;
    }

    private static Optional<String> longestCommonSubsequence(String left, String right, int[][] subsequences) {
        LinkedList<String> longestCommonSubsequence = new LinkedList<>();
        int leftIndex = left.length();
        int rightIndex = right.length();
        while (leftIndex != 0 && rightIndex != 0) {
            boolean upStep = subsequences[leftIndex - 1][rightIndex] <= subsequences[leftIndex][rightIndex] &&
                    subsequences[leftIndex][rightIndex - 1] < subsequences[leftIndex][rightIndex];
            boolean diagonalStep = subsequences[leftIndex - 1][rightIndex] < subsequences[leftIndex][rightIndex] &&
                    subsequences[leftIndex][rightIndex - 1] < subsequences[leftIndex][rightIndex];
            if (diagonalStep) {
                longestCommonSubsequence.addFirst(String.valueOf(left.charAt(leftIndex - 1)));
                leftIndex--;
                rightIndex--;
            } else if (upStep) {
                leftIndex--;
            } else {
                rightIndex--;
            }
        }
        return longestCommonSubsequence.isEmpty() ?
                Optional.empty() : Optional.of(String.join("", longestCommonSubsequence));
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