package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InterleavingStringDisjointCriterion {

    public static boolean check(String left, String right, String interleaving) {
        valid(left, right, interleaving);
        if (left.length() + right.length() != interleaving.length()) {
            return false;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (char character : interleaving.toCharArray()) {
            if (character == left.charAt(leftIndex)) {
                leftIndex++;
            } else if (character == right.charAt(rightIndex)) {
                rightIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    private static void valid(String left, String right, String interleaving) {
        if (left == null) {
            throw new IllegalArgumentException("Parameter left cannot be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("Parameter right cannot be null");
        }
        if (interleaving == null) {
            throw new IllegalArgumentException("Parameter interleaving cannot be null");
        }
    }

}