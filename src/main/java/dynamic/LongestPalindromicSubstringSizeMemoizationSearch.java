package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestPalindromicSubstringSizeMemoizationSearch {

    private static final int EMPTY = -1;

    public static int search(String string) {
        valid(string);
        int[][] substringSizes = new int[string.length()][string.length()];
        Arrays.stream(substringSizes).forEach(array -> Arrays.fill(array, EMPTY));
        return search(string, 0, string.length() - 1, substringSizes);
    }

    private static void valid(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Parameter string cannot be null");
        }
    }

    private static int search(String string, int startIndex, int endIndex, int[][] substringSizes) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (substringSizes[startIndex][endIndex] == EMPTY) {
            log.trace("Search longest palindromic substring startIndex: {}, endIndex: {}", startIndex, endIndex);
            if (startIndex == endIndex) {
                substringSizes[startIndex][endIndex] = 1;
            } else if (string.charAt(startIndex) == string.charAt(endIndex)) {
                substringSizes[startIndex][endIndex] = (2 +
                        search(string, startIndex + 1, endIndex - 1, substringSizes));
            } else {
                substringSizes[startIndex][endIndex] = Math.max(search(string, startIndex + 1,
                        endIndex, substringSizes), search(string, startIndex, endIndex - 1, substringSizes));
            }
        } else {
            log.trace("Memoization longest palindromic substring startIndex: {}, endIndex: {}", startIndex, endIndex);
        }
        return substringSizes[startIndex][endIndex];
    }

}