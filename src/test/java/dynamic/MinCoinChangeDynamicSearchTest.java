package dynamic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MinCoinChangeDynamicSearchTest {

    @Test
    public void shouldSearch() {
        // Given
        final int sum = 11;
        final List<Integer> denominations = Arrays.asList(1, 2, 3);

        // When
        final Optional<Integer> result = MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThat(result).get().isEqualTo(4);
    }

    @Test
    public void shouldSearchCaseNotMultipleSum() {
        // Given
        final int sum = 11;
        final List<Integer> denominations = Collections.singletonList(2);

        // When
        final Optional<Integer> result = MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldSearchCaseZeroSum() {
        // Given
        final int sum = 0;
        final List<Integer> denominations = Arrays.asList(1, 2, 3);

        // When
        final Optional<Integer> result = MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThat(result).get().isEqualTo(0);
    }

    @Test
    public void shouldSearchCaseNegativeSum() {
        // Given
        final int sum = -1;
        final List<Integer> denominations = Arrays.asList(1, 2, 3);

        // When
        final ThrowingCallable result = () -> MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldSearchCaseNullDenominations() {
        // Given
        final int sum = 10;
        final List<Integer> denominations = null;

        // When
        final ThrowingCallable result = () -> MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldSearchCaseNegativeDenominations() {
        // Given
        final int sum = 10;
        final List<Integer> denominations = Arrays.asList(-11, 2, 3);

        // When
        final ThrowingCallable result = () -> MinCoinChangeDynamicSearch.search(sum, denominations);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

}