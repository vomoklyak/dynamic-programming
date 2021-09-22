package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinDroppingEggFloorMemoizationSearch {

    private static final int EMPTY = -1;

    public static void main(String[] args) {
        System.out.println(search(32, 3));
    }

    public static int search(int numberOfFloors, int numberOfEggs) {
        valid(numberOfFloors, numberOfEggs);
        int[][] minFloors = new int[numberOfFloors + 1][numberOfEggs + 1];
        Arrays.stream(minFloors).forEach(array -> Arrays.fill(array, EMPTY));
        return recursiveSearch(numberOfFloors, numberOfEggs, minFloors);
    }

    private static int recursiveSearch(int numberOfFloors, int numberOfEggs, int[][] minFloors) {
        if (minFloors[numberOfFloors][numberOfEggs] == EMPTY) {
            log.trace("Search min floor number of floors: {}, number of eggs: {}", numberOfFloors, numberOfEggs);
            if (numberOfFloors == 0 || numberOfFloors == 1 || numberOfEggs == 1) {
                minFloors[numberOfFloors][numberOfEggs] = numberOfFloors;
            } else {
                int minFloor = numberOfFloors;
                for (int floor = 1; floor <= numberOfFloors; floor++) {
                    int tempFloor = Math.max(recursiveSearch(floor - 1, numberOfEggs - 1, minFloors),
                            recursiveSearch(numberOfFloors - floor, numberOfEggs, minFloors));
                    minFloor = Math.min(tempFloor, minFloor);
                }
                minFloors[numberOfFloors][numberOfEggs] = minFloor + 1;
            }
        } else {
            log.trace("Memoization min floor number of floors: {}, number of eggs: {}", numberOfFloors, numberOfEggs);
        }
        return minFloors[numberOfFloors][numberOfEggs];
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