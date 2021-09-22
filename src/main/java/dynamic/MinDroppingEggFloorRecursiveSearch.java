package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinDroppingEggFloorRecursiveSearch {

    public static void main(String[] args) {
        System.out.println(search(100, 2));
    }

    public static int search(int numberOfFloors, int numberOfEggs) {
        valid(numberOfFloors, numberOfEggs);
        log.trace("Search min floor number of floors: {}, number of eggs: {}", numberOfFloors, numberOfEggs);
        if (numberOfFloors == 0 || numberOfFloors == 1 || numberOfEggs == 1) {
            return numberOfFloors;
        }
        int minFloor = numberOfFloors;
        for (int floor = 1; floor <= numberOfFloors; floor++) {
            int tempFloor = Math.max(search(floor - 1, numberOfEggs - 1),
                    search(numberOfFloors - floor, numberOfEggs));
            minFloor = Math.min(tempFloor, minFloor);
        }
        return minFloor + 1;
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
