package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InterleavingStringSearch {

    public static List<String> search(String left, String right) {
        valid(left, right);
        List<String> interleavings = new ArrayList<>();
        search(left, 0, right, 0, "", interleavings);
        return interleavings;
    }

    private static void valid(String left, String right) {
        if (left == null) {
            throw new IllegalArgumentException("Parameter left cannot be null");
        }
        if (right == null) {
            throw new IllegalArgumentException("Parameter right cannot be null");
        }
    }

    private static void search(String left, int leftIndex, String right, int rightIndex,
                               String interleaving, List<String> interleavings) {
        log.trace("Search interleavings: left index: {}, right: {}, current interleaving: {}",
                leftIndex, rightIndex, interleaving);
        if (interleaving.length() == left.length() + right.length()) {
            interleavings.add(interleaving);
        } else {
            if (leftIndex < left.length()) {
                search(left, leftIndex + 1, right, rightIndex,
                        interleaving + left.charAt(leftIndex), interleavings);
            }
            if (rightIndex < right.length()) {
                search(left, leftIndex, right, rightIndex + 1,
                        interleaving + right.charAt(rightIndex), interleavings);
            }
        }
    }

}
