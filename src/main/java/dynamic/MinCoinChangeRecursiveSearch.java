package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MinCoinChangeRecursiveSearch {

    public static Optional<Integer> search(int sum, List<Integer> denominations) {
        valid(sum, denominations);
        int numberOfCoins = recursiveSearch(sum, denominations);
        return numberOfCoins == Integer.MAX_VALUE ? Optional.empty() : Optional.of(numberOfCoins);
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

    private static Integer recursiveSearch(int sum, List<Integer> denominations) {
        log.trace("Search coin change sum: {}", sum);
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }
        if (sum == 0) {
            return 0;
        }
        return denominations.stream()
                .map(denomination -> recursiveSearch(sum - denomination, denominations))
                .min(Integer::compareTo)
                .filter(value -> value != Integer.MAX_VALUE)
                .map(value -> value + 1)
                .orElse(Integer.MAX_VALUE);
    }

}