package dynamic;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

public class LongestPalindromicSubstringSizeDynamicSearchTest {

    @Test
    public void shouldSearch() {
        // Given
        final String string = "1A2A3B4A5A6";

        // When
        final int result = LongestPalindromicSubstringSizeDynamicSearch.search(string);

        // Then
        Assertions.assertThat(result).isEqualTo("AABAA".length());
    }

    @Test
    public void shouldSearchCaseOneCharPalindrome() {
        // Given
        final String string = "ABCDE";

        // When
        final int result = LongestPalindromicSubstringSizeDynamicSearch.search(string);

        // Then
        Assertions.assertThat(result).isEqualTo("E".length());
    }

    @Test
    public void shouldSearchCaseTwoCharPalindrome() {
        // Given
        final String string = "AA";

        // When
        final int result = LongestPalindromicSubstringSizeDynamicSearch.search(string);

        // Then
        Assertions.assertThat(result).isEqualTo("AA".length());
    }

    @Test
    public void shouldSearchCaseEmptyString() {
        // Given
        final String string = "";

        // When
        final int result = LongestPalindromicSubstringSizeDynamicSearch.search(string);

        // Then
        Assertions.assertThat(result).isEqualTo("".length());
    }

    @Test
    public void shouldSearchCaseNullString() {
        // Given
        final String string = null;

        // When
        final ThrowingCallable result = () -> LongestPalindromicSubstringSizeDynamicSearch.search(string);

        // Then
        Assertions.assertThatThrownBy(result).isInstanceOf(IllegalArgumentException.class);
    }

}