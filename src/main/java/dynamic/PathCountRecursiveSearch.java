package dynamic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PathCountRecursiveSearch {

    public static int search(int numberOfRows, int numberOfColumns) {
        log.trace("Search paths: number of rows: {}, number of columns: {}", numberOfRows, numberOfColumns);
        if (numberOfRows == 1 && numberOfColumns == 1) {
            return 0;
        }
        if (numberOfRows == 1 || numberOfColumns == 1) {
            return 1;
        }
        return search(numberOfRows - 1, numberOfColumns) +
                search(numberOfRows, numberOfColumns - 1);
    }

}
