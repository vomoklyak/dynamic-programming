package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CombinationCountDynamicSearch {

    public static int search(int k, int n) {
        int[][] pascalTriangle = pascalTriangle(n + 1);
        return pascalTriangle[n][k];
    }

    private static int[][] pascalTriangle(int n) {
        int[][] pascalTriangle = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column <= row; column++) {
                if (column == 0 || row == column) {
                    pascalTriangle[row][column] = 1;
                } else {
                    pascalTriangle[row][column] =
                            pascalTriangle[row - 1][column - 1] + pascalTriangle[row - 1][column];
                }
            }
        }
        return pascalTriangle;
    }

}