package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CombinationCountSearch {

    public static int combinations(int k, int n) {
        return product(n - k + 1, n) / product(1, k);
    }

    private static int product(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .reduce(1, ((left, right) -> left * right));
    }

}