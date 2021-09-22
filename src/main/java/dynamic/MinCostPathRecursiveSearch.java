package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinCostPathRecursiveSearch {

    public static int search(int[][] cellCosts, int row, int column) {
        log.trace("Search min cost path row: {}, column: {}", row, column);
        if (row == 0 && column == 0) {
            return cellCosts[0][0];
        }
        if (row == 0) {
            return search(cellCosts, 0, column - 1) + cellCosts[0][column];
        }
        if (column == 0) {
            return search(cellCosts, row - 1, 0) + cellCosts[row][0];
        }
        int leftStepCost = search(cellCosts, row, column - 1);
        int upStepCost = search(cellCosts, row - 1, column);
        return Math.min(leftStepCost, upStepCost) + cellCosts[row][column];
    }

    public static int memoizationSearch(int[][] cellCosts, int row, int column) {
        int[][] minCellCosts = new int[row + 1][column + 1];
        Arrays.stream(minCellCosts).forEach(array -> Arrays.fill(array, Integer.MIN_VALUE));
        return memoizationSearch(minCellCosts, cellCosts, row, column);
    }

    private static int memoizationSearch(int[][] minCellCosts, int[][] cellCosts, int row, int column) {
        if (minCellCosts[row][column] != Integer.MIN_VALUE) {
            return minCellCosts[row][column];
        } else {
            log.trace("Search min cost path row: {}, column: {}", row, column);
            if (row == 0 && column == 0) {
                minCellCosts[0][0] = cellCosts[0][0];
            } else if (row == 0) {
                minCellCosts[0][column] = memoizationSearch(minCellCosts, cellCosts, 0, column - 1) + cellCosts[0][column];
            } else if (column == 0) {
                minCellCosts[row][0] = memoizationSearch(minCellCosts, cellCosts, row - 1, 0) + cellCosts[row][0];
            } else {
                int leftStepCost = memoizationSearch(minCellCosts, cellCosts, row, column - 1);
                int upStepCost = memoizationSearch(minCellCosts, cellCosts, row - 1, column);
                minCellCosts[row][column] = Math.min(leftStepCost, upStepCost) + cellCosts[row][column];
            }
        }
        return minCellCosts[row][column];
    }

}