package algorithms.dynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SubArrayProblemTest {


    private static Stream<Arguments> subArrayCases(){

        return Stream.of(
                Arguments.of(new int[] {}, new int[]{0,0}),
                Arguments.of(new int[] {1,2,-5,2,4,2,-2}, new int[]{3,5}),
                Arguments.of(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}, new int[]{3,6})
        );
    }

    @ParameterizedTest
    @MethodSource("subArrayCases")
    public void subArrayDynamic_giveSubArray_returnsRightResult(int[] input, int[] expected){
        var result = SubArrayProblem.subArrayDynamic(input);

        Assertions.assertArrayEquals(expected, result);
    }

}
