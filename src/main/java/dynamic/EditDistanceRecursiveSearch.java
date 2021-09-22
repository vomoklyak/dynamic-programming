package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EditDistanceRecursiveSearch {

    public static int search(String left, String right) {
        return search(left, 0, right, 0, Operation.FORWARD);
    }

    public static int search(String left, int leftIndex, String right, int rightIndex, Operation operation) {
        log.trace("Operation: {}, left index: {}, right index: {} ", operation, leftIndex, rightIndex);
        if (left.length() == leftIndex) {
            return right.length() - rightIndex;
        }
        if (right.length() == rightIndex) {
            return left.length() - leftIndex;
        }
        if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
            return search(left, leftIndex + 1, right, rightIndex + 1, Operation.FORWARD);
        }
        int delete = search(left, leftIndex + 1, right, rightIndex, Operation.DELETE);
        int update = search(left, leftIndex + 1, right, rightIndex + 1, Operation.UPDATE);
        int insert = search(left, leftIndex, right, rightIndex + 1, Operation.INSERT);
        return Math.min(Math.min(delete, update), insert) + 1;
    }

    private enum Operation {
        FORWARD,
        DELETE,
        UPDATE,
        INSERT
    }

}