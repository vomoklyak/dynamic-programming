package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinDroppingEggFloorDynamicSearch {

    public static void main(String[] args) {
        System.out.println(Math.log10(100) / Math.log10(2));
        System.out.println(search(4, 100));
    }

    public static int search(int numberOfEggs, int numberOfFloors) {
        valid(numberOfEggs, numberOfFloors);
        int[][] minFloors = new int[numberOfEggs + 1][numberOfFloors + 1];
        // row - number of floors
        for (int row = 1; row <= numberOfEggs; row++) {
            minFloors[row][1] = 1;
        }
        // column - number of floors
        for (int column = 1; column <= numberOfFloors; column++) {
            minFloors[1][column] = column;
        }
        for (int row = 2; row <= numberOfEggs; row++) {
            for (int column = 2; column <= numberOfFloors; column++) {
                minFloors[row][column] = Integer.MAX_VALUE;
                for (int subColumn = 1; subColumn <= column; subColumn++) {
                    int minFloor = 1 + Math.max(minFloors[row - 1][subColumn - 1], minFloors[row][column - subColumn]);
                    minFloors[row][column] = Math.min(minFloors[row][column], minFloor);
                }
            }
        }
        return minFloors[numberOfEggs][numberOfFloors];
    }

    private static void valid(int numberOfFloors, int numberOfEggs) {
        if (numberOfFloors < 0) {
            throw new IllegalArgumentException("Parameter numberOfFloors cannot be negative");
        }
        if (numberOfEggs < 0) {
            throw new IllegalArgumentException("Parameter numberOfEggs cannot be negative");
        }
    }

}