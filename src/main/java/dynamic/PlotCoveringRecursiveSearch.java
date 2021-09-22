package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PlotCoveringRecursiveSearch {

    // plotSize size 2*k, tile size 2
    public static int search(int plotSize) {
        valid(plotSize);
        log.trace("Search covering plot size: {}", plotSize);
        if (plotSize == 0) {
            return 0;
        }
        if (plotSize == 1) {
            return 1;
        }
        if (plotSize == 2) {
            return 2;
        }
        return search(plotSize - 1) + search(plotSize - 2);
    }

    private static void valid(int plotSize) {
        if (plotSize < 0) {
            throw new IllegalArgumentException(String.format(
                    "Parameter plotSize should be non negative: %s", plotSize));
        }
    }

}