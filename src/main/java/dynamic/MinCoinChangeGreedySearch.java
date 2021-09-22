package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinCoinChangeGreedySearch {

    public static Optional<Integer> search(int sum, List<Integer> denominations) {
        valid(sum, denominations);
        TreeSet<Integer> sortedDenominations = new TreeSet<>(denominations);
        int currentSum = sum;
        int numberOfCoins = 0;
        while (currentSum > 0) {
            Integer floorDenomination = sortedDenominations.floor(currentSum);
            if (floorDenomination == null) {
                currentSum = Integer.MIN_VALUE;
            } else {
                currentSum -= floorDenomination;
                numberOfCoins++;
            }
        }
        return currentSum == Integer.MIN_VALUE ? Optional.empty() : Optional.of(numberOfCoins);
    }

    public static Optional<List<Integer>> searchCoins(int sum, List<Integer> denominations) {
        valid(sum, denominations);
        TreeSet<Integer> sortedDenominations = new TreeSet<>(denominations);
        List<Integer> numberOfCoins = new LinkedList<>();
        int currentSum = sum;
        while (currentSum > 0) {
            Integer floorDenomination = sortedDenominations.floor(currentSum);
            if (floorDenomination == null) {
                currentSum = Integer.MIN_VALUE;
            } else {
                numberOfCoins.add(floorDenomination);
                currentSum -= floorDenomination;
            }
        }
        return currentSum == Integer.MIN_VALUE ? Optional.empty() : Optional.of(numberOfCoins);
    }

    private static void valid(int sum, List<Integer> denominations) {
        if (sum < 0) {
            throw new IllegalArgumentException("Parameter cannot be negative");
        }
        if (denominations == null || denominations.isEmpty()) {
            throw new IllegalArgumentException("Parameter denominations cannot be null or empty");
        }
        if (denominations.stream().anyMatch(value -> value <= 0)) {
            throw new IllegalArgumentException("Denomination cannot be negative");
        }
    }

}