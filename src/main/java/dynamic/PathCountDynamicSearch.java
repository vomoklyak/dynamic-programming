package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PathCountDynamicSearch {

    public static int search(int numberOfRows, int numberOfColumns) {
        int[][] paths = new int[numberOfColumns][numberOfColumns];
        for (int row = 1; row < numberOfRows; row++) {
            paths[row][0] = 1;
        }
        for (int column = 1; column < numberOfColumns; column++) {
            paths[0][column] = 1;
        }
        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                paths[row][column] = paths[row - 1][column] + paths[row][column - 1];
            }
        }
        return paths[numberOfRows - 1][numberOfColumns - 1];
    }

}