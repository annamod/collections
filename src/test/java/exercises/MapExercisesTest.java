package exercises;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapExercisesTest {

    private final MapExercises sut = new MapExercises();

    @Test
    public void testCountWords() {
        // given
        List<String> givenList = Lists.newArrayList("aaa", "bbb", "aaa", "bbb", "ccc", "bbb");

        // when
        Map<String, Integer> actualMap = sut.countWords(givenList);

        // then
        Map<String, Integer> expectedMap = ImmutableMap.of("aaa", 2, "bbb", 3, "ccc", 1);
        assertThat(actualMap, equalTo(expectedMap));
    }

    @Test
    public void testFilterSingleWords() {
        // given
        Map<String, Integer> givenMap = Maps.newHashMap(ImmutableMap.of("aaa", 2, "bbb", 3, "ccc", 1));

        // when
        sut.filterSingleWords(givenMap);

        // then
        Map<String, Integer> expectedMap = Maps.newHashMap(ImmutableMap.of("aaa", 2, "bbb", 3));
        assertThat(givenMap, equalTo(expectedMap));
    }

    @Test
    public void testGetWordWithLargestCount() {
        // given
        Map<String, Integer> givenMap = Maps.newHashMap(ImmutableMap.of("aaa", 2, "bbb", 3, "ccc", 1, "ddd", 3));

        // when
        Set<String> actualResult = sut.getWordsWithLargestCount(givenMap);

        // then
        assertThat(actualResult, equalTo(Sets.newHashSet("bbb", "ddd")));
    }
}