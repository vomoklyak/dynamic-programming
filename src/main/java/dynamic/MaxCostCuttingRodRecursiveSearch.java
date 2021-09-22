package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxCostCuttingRodRecursiveSearch {

    public static int search(int[] costs, int rodLength) {
        valid(costs, rodLength);
        return recursiveSearch(costs, rodLength);
    }

    private static int recursiveSearch(int[] costs, int rodLength) {
        log.trace("Search max cost, rod length: {}", rodLength);
        if (rodLength <= 0) {
            return 0;
        }
        return IntStream.rangeClosed(1, rodLength)
                .map(currentLength -> costs[currentLength - 1] +
                        recursiveSearch(costs, rodLength - currentLength))
                .max()
                .orElse(0);
    }

    private static void valid(int[] costs, int rodLength) {
        if (costs == null || costs.length == 0) {
            throw new IllegalArgumentException("Parameter costs cannot be null or empty");
        }
        if (rodLength < 0) {
            throw new IllegalArgumentException("Parameter rodLength cannot be negative");
        }
    }

}