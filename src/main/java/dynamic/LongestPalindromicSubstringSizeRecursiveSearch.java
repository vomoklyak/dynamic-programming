package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongestPalindromicSubstringSizeRecursiveSearch {

    public static int search(String string) {
        valid(string);
        return search(string, 0, string.length() - 1);
    }

    private static int search(String string, int startIndex, int endIndex) {
        log.trace("Search longest palindromic substring startIndex: {}, endIndex: {}", startIndex, endIndex);
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            return 1;
        }
        if (string.charAt(startIndex) == string.charAt(endIndex)) {
            return 2 + search(string, startIndex + 1, endIndex - 1);
        }
        return Math.max(search(string, startIndex + 1, endIndex),
                search(string, startIndex, endIndex - 1));
    }

    private static void valid(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Parameter string cannot be null");
        }
    }

}