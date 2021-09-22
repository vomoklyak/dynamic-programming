package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScorePathCountRecursiveSearch {

    public static int search(int score, List<Integer> points) {
        if (score < 0) {
            return 0;
        }
        if (score == 0) {
            return 1;
        }
        return points.stream()
                .map(point -> search(score - point, points))
                .reduce(0, Integer::sum);
    }

}
