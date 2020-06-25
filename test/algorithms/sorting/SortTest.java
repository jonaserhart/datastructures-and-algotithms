package algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    private static Stream<Arguments> sortParams(){

        Comparator<Integer> integerComparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }

            @Override
            public String toString() {
                return "standard integer comparator";
            }
        };

        Supplier<Sort<Integer>> quickSort = new Supplier<>() {
            @Override
            public Sort<Integer> get() {
                return new QuickSort<>();
            }
            @Override
            public String toString() {
                return "quickSort";
            }
        };

        Supplier<Sort<Integer>> mergeSort = new Supplier<>() {
            @Override
            public Sort<Integer> get() {
                return new MergeSort<>();
            }
            @Override
            public String toString() {
                return "mergeSort";
            }
        };

        return Stream.of(
                Arguments.of(mergeSort, new Integer[]{}, new Integer[]{}, integerComparator),
                Arguments.of(mergeSort, new Integer[]{1,2,3,4}, new Integer[]{1,2,3,4}, integerComparator),
                Arguments.of(mergeSort, new Integer[]{4,3,2,1}, new Integer[]{1,2,3,4}, integerComparator),
                Arguments.of(mergeSort, new Integer[]{7,4,3,8,2,5,1,6}, new Integer[]{1,2,3,4,5,6,7,8}, integerComparator),
                Arguments.of(quickSort, new Integer[]{}, new Integer[]{}, integerComparator),
                Arguments.of(quickSort, new Integer[]{1,2,3,4}, new Integer[]{1,2,3,4}, integerComparator),
                Arguments.of(quickSort, new Integer[]{4,3,2,1}, new Integer[]{1,2,3,4}, integerComparator),
                Arguments.of(quickSort, new Integer[]{7,4,3,8,2,5,1,6}, new Integer[]{1,2,3,4,5,6,7,8}, integerComparator)
            );
    }

    @ParameterizedTest
    @MethodSource("sortParams")
    public void quickSort_giveCollectionExpectedAndComparator_returnsExpected(Supplier<Sort<Integer>> algorithm, Integer[] collection, Integer[] expected, Comparator<Integer> comparator){
        var sort = algorithm.get();

        sort.sort(collection, comparator);

        Assertions.assertArrayEquals(expected, collection);
    }

}
