package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EditDistanceDynamicSearch {

    public static int search(String left, String right) {
        int[][] editDistances = new int[left.length() + 1][right.length() + 1];
        editDistances[0][0] = 0;
        for (int index = 1; index <= left.length(); index++) {
            editDistances[index][0] = index;
        }
        for (int index = 1; index <= right.length(); index++) {
            editDistances[0][index] = index;
        }
        // row left string char index
        for (int row = 1; row <= left.length(); row++) {
            // column right string char index
            for (int column = 1; column <= right.length(); column++) {
                if (left.charAt(row - 1) == right.charAt(column - 1)) {
                    editDistances[row][column] = editDistances[row - 1][column - 1];
                } else {
                    editDistances[row][column] = Math.min(Math.min(editDistances[row - 1][column],
                            editDistances[row][column - 1]), editDistances[row - 1][column - 1]) + 1;
                }
            }
        }
        return editDistances[left.length()][right.length()];
    }

}