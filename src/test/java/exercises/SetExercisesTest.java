package exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SetExercisesTest {

    private final SetExercises sut = new SetExercises();

    @Test
    public void testGetUniqueWords() {
        // given
        List<String> givenList = Arrays.asList("d", "b", "c", "a", "c", "a");

        // when
        Set<String> actualSet = sut.getUniqueWords(givenList);

        // then
        Set<String> expectedSet = Stream.of("a", "b", "c", "d").collect(toSet());
        assertThat(actualSet, equalTo(expectedSet));
    }

    @Test
    public void testGetUniqueWordsWithOrder() {
        // given
        List<String> givenList = Arrays.asList("d", "b", "c", "a", "c", "a");

        // when
        Set<String> actualSet = sut.getUniqueWordsWithSameOrder(givenList);

        // then
        Set<String> expectedSet = Stream.of("d", "b", "c", "a").collect(Collectors.toCollection(LinkedHashSet::new));
        assertThat(actualSet, equalTo(expectedSet));
    }
}