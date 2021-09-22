package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScorePathCountDynamicSearch {

    public static int search(int score, List<Integer> points) {
        int[] scores = new int[score + 1];
        scores[0] = 1;
        for (int currentScore = 1; currentScore <= score; currentScore++) {
            for (int point : points) {
                if (point <= currentScore) {
                    scores[currentScore] += scores[currentScore - point];
                }
            }
        }
        return scores[score];
    }

}