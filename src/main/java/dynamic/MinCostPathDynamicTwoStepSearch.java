package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinCostPathDynamicTwoStepSearch {

    public static int search(int[][] cellCosts, int row, int column) {
        int[][] minCellCosts = new int[row + 1][column + 1];
        minCellCosts[0][0] = cellCosts[0][0];
        for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
            log.trace("Compute min cost path row: {}, column: {}", rowIndex, 0);
            minCellCosts[rowIndex][0] = minCellCosts[rowIndex - 1][0] + cellCosts[rowIndex][0];
        }
        for (int columnIndex = 1; columnIndex <= column; columnIndex++) {
            log.trace("Compute min cost path row: {}, column: {}", 0, columnIndex);
            minCellCosts[0][columnIndex] = minCellCosts[0][columnIndex - 1] + cellCosts[0][columnIndex];
        }
        for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
            for (int columnIndex = 1; columnIndex <= column; columnIndex++) {
                log.trace("Compute min cost path row: {}, column: {}", row, column);
                int downStepCost = minCellCosts[rowIndex - 1][columnIndex];
                int rightStepCost = minCellCosts[rowIndex][columnIndex - 1];
                minCellCosts[rowIndex][columnIndex] =
                        Math.min(downStepCost, rightStepCost) + cellCosts[rowIndex][columnIndex];
            }
        }
        return minCellCosts[row][column];
    }

}