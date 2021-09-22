package dynamic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

public class LongestIncreasingSubArraySizeRecursiveSearchTest {

    @Test
    public void shouldSearch() {
        // Given
        final int[] array = new int[]{1, 11, 2, 10, 4, 5, 2, 1};

        // When
        final int result = LongestIncreasingSubArraySizeRecursiveSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    public void shouldSearchCaseLongestDecreasingSubArray() {
        // Given
        final int[] array = new int[]{6, 5, 4, 3, 2, 1};

        // When
        final int result = LongestIncreasingSubArraySizeRecursiveSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldSearchCaseEmptyArray() {
        // Given
        final int[] array = {};

        // When
        final int result = LongestIncreasingSubArraySizeRecursiveSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldSearchCaseNullArray() {
        // Given
        final int[] array = null;

        // When
        final ThrowableAssert.ThrowingCallable result = () ->
                LongestIncreasingSubArraySizeRecursiveSearch.search(array);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

}