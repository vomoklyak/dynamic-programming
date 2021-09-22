package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaxCostCuttingRodDynamicSearch {

    public static int search(int[] costs, int rodLength) {
        valid(costs, rodLength);
        int[] maxCosts = new int[rodLength + 1];
        Arrays.fill(maxCosts, Integer.MIN_VALUE);
        maxCosts[0] = 0;
        for (int length = 1; length <= rodLength; length++) {
            for (int subLength = 0; subLength < length; subLength++) {
                maxCosts[length] = Math.max(maxCosts[length], costs[subLength] + maxCosts[length - subLength - 1]);
            }
        }
        return maxCosts[rodLength];
    }

    public static int[] searchRods(int[] costs, int rodLength) {
        valid(costs, rodLength);
        int[] lengths = new int[rodLength];
        int[] maxCosts = new int[rodLength + 1];
        Arrays.fill(maxCosts, Integer.MIN_VALUE);
        maxCosts[0] = 0;
        for (int length = 1; length <= rodLength; length++) {
            for (int subLength = 0; subLength < length; subLength++) {
                int cost = costs[subLength] + maxCosts[length - subLength - 1];
                if (maxCosts[length] < cost) {
                    maxCosts[length] = cost;
                    lengths[length - 1] = subLength;
                }
            }
        }
        return rods(lengths);
    }

    private static int[] rods(int[] lengths) {
        int[] rods = new int[lengths.length];
        Arrays.fill(rods, Integer.MIN_VALUE);
        int length = lengths.length - 1;
        while (length != lengths[length]) {
            rods[length] = lengths[length] + 1;
            length = length - lengths[length] - 1;
        }
        rods[length] = lengths[length] + 1;
        return Arrays.stream(rods)
                .filter(value -> value != Integer.MIN_VALUE)
                .toArray();
    }

    private static void valid(int[] costs, int length) {
        if (costs == null || costs.length == 0) {
            throw new IllegalArgumentException("Parameter costs cannot be null or empty");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Parameter length cannot be negative");
        }
    }

}