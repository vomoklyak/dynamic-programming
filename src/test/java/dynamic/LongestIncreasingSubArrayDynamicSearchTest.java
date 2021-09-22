package dynamic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

public class LongestIncreasingSubArrayDynamicSearchTest {

    @Test
    public void shouldSearch() {
        // Given
        final int[] array = new int[]{1, 11, 2, 10, 4, 5, 2, 1};

        // When
        final int[] result = LongestIncreasingSubArrayDynamicSearch.search(array);

        // Then
        Assertions.assertThat(result).containsExactly(1, 2, 4, 5);
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
        final ThrowableAssert.ThrowingCallable result = () -> LongestBitonicSubArraySizeDynamicSearch.search(array);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

}