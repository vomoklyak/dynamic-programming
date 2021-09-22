package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinCoinChangeDynamicSearch {

    public static Optional<Integer> search(int sum, List<Integer> denominations) {
        valid(sum, denominations);
        int[] coins = new int[sum + 1];
        for (int currentSum = 1; currentSum <= sum; currentSum++) {
            coins[currentSum] = Integer.MAX_VALUE;
        }
        for (int currentSum = 1; currentSum <= sum; currentSum++) {
            for (int currentDenomination : denominations) {
                int residualSum = currentSum - currentDenomination;
                if (currentDenomination <= currentSum && coins[residualSum] < Integer.MAX_VALUE) {
                    coins[currentSum] = coins[residualSum] + 1;
                }
            }
        }
        return coins[sum] == Integer.MAX_VALUE ? Optional.empty() : Optional.of(coins[sum]);
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