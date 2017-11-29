package exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListExercisesTest {

    private final ListExercises sut = new ListExercises();

    @Test
    public void testSort() {
        // given
        List<String> givenList = Arrays.asList("ccc", "bbb", "aaa", "fff", "ddd");

        // when
        List<String> actualList = sut.sort(givenList);

        // then
        List<String> expectedList = Arrays.asList("fff", "ddd", "ccc", "bbb", "aaa");
        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void testToUpperCaseList() {
        // given
        List<String> givenList = Arrays.asList("ccc", "bbb", "aaa", "fff", "ddd");

        // when
        List<String> actualList = sut.toUpperCaseList(givenList);

        // then
        List<String> expectedList = Arrays.asList("CCC", "BBB", "AAA", "FFF", "DDD");
        assertThat(actualList, equalTo(expectedList));
    }

    @Test
    public void testCheckIfAlreadyExists_forExistingElement() {
        // given
        List<String> givenList = Arrays.asList("ccc", "bbb", "aaa", "fff", "ddd");

        // when
        boolean result = sut.checkIfAlreadyExists(givenList, "fff");

        // then
        assertThat(result, equalTo(true));
    }

    @Test
    public void testCheckIfAlreadyExists_forNonExistingElement() {
        // given
        List<String> givenList = Arrays.asList("ccc", "bbb", "aaa", "fff", "ddd");

        // when
        boolean result = sut.checkIfAlreadyExists(givenList, "eee");

        // then
        assertThat(result, equalTo(false));
    }
}