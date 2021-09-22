package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CombinationCountRecursiveSearch {

    public static int search(int k, int n) {
        log.trace("Search number of combinations k: {}, n: {}", k, n);
        if (k == 0 || n == 0 || k == n) {
            return 1;
        }
        return search(k - 1, n - 1) + search(k, n - 1);
    }

}