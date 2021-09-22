package dynamic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

public class LongestBitonicSubArraySizeDynamicSearchTest {

    @Test
    public void shouldSearch() {
        // Given
        final int[] array = new int[]{1, 11, 2, 10, 4, 5, 2, 1};

        // When
        final int result = LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldSearchCaseOnlyLongestIncreasingSubArray() {
        // Given
        final int[] array = new int[]{1, 2, 3, 4, 5, 6};

        // When
        final int result = LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldSearchCaseOnlyLongestDecreasingSubArray() {
        // Given
        final int[] array = new int[]{6, 5, 4, 3, 2, 1};

        // When
        final int result = LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldSearchCaseEmptyArray() {
        // Given
        final int[] array = {};

        // When
        final int result = LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldSearchCaseNullArray() {
        // Given
        final int[] array = null;

        // When
        final ThrowingCallable result = () -> LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

}