import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GeneratorTest {

    @Test
    public void testSingleGeneration_Rule1(){
        ArrayList<Integer> testList = new ArrayList<>(List.of(0,0,0,0,1,1,0,1));
        ArrayList<Integer> expectedList = new ArrayList<>(List.of(1,1,1,0,0,0,0,0));
        assertEquals(expectedList, Generator.generate(testList, 1));
    }

    @ParameterizedTest
    @MethodSource("arrayListProvider_rule2")
    public void testSingleGenerationRule2_Parametrized(ArrayList<Integer> testList, ArrayList<Integer> expectedList){
        assertEquals(expectedList, Generator.generate(testList, 2));
    }
    static Stream<Arguments> arrayListProvider_rule2(){

        return Stream.of(
                arguments(new ArrayList<>(List.of(0,0,0,0,1,1,0,1)),
                        new ArrayList<>(List.of(0,0,0,0,1,0,0,0))),
                arguments(new ArrayList<>(List.of(1,1,1,1,1,1,1,1)),
                        new ArrayList<>(List.of(0,0,0,0,0,0,0,0))),
                arguments(new ArrayList<>(List.of(0,0,0,0,0,0,0,0)),
                        new ArrayList<>(List.of(0,0,0,0,0,0,0,0))),
                arguments(new ArrayList<>(List.of(0,0,0,0,1,0,0,0)),
                        new ArrayList<>(List.of(0,0,0,1,0,0,0,0))),
                arguments(new ArrayList<>(List.of(0,0,0,0,0,0,0,1,0,0,0,0,0,0,0)),
                        new ArrayList<>(List.of(0,0,0,0,0,0,1,0,0,0,0,0,0,0,0)))


        );
    }

    @ParameterizedTest
    @MethodSource("arrayListProvider")
    public void testSingleGenerationRule1_Parametrized(ArrayList<Integer> testList, ArrayList<Integer> expectedList){
        assertEquals(expectedList, Generator.generate(testList, 1));
    }
    static Stream<Arguments> arrayListProvider(){

       return Stream.of(
               arguments(new ArrayList<>(List.of(0,0,0,0,1,1,0,1)),
                       new ArrayList<>(List.of(1,1,1,0,0,0,0,0))),
               arguments(new ArrayList<>(List.of(1,1,1,1,1,1,1,1)),
                       new ArrayList<>(List.of(0,0,0,0,0,0,0,0))),
               arguments(new ArrayList<>(List.of(0,0,0,0,0,0,0,0)),
                       new ArrayList<>(List.of(1,1,1,1,1,1,1,1))),
               arguments(new ArrayList<>(List.of(0,0,0,0,1,0,0,0)),
                       new ArrayList<>(List.of(1,1,1,0,0,0,1,1))),
               arguments(new ArrayList<>(List.of(0,0,0,0,0,0,0,1,0,0,0,0,0,0,0)),
                       new ArrayList<>(List.of(1,1,1,1,1,1,0,0,0,1,1,1,1,1,1)))


       );
    }

    @ParameterizedTest
    @MethodSource("neighbourListProvider_Rule1")
    public void testCalculateNextCell_Rule1(ArrayList<Integer> neighbour, int nextCell){

        Generator generator = new Generator();
        int[][] testArray = {{1,1,1},{1,1,0},{1,0,1},{1,0,0},{0,1,1},{0,1,0},{0,0,1},{0,0,0}};
        int[] expectedResultArray = {0,0,0,0,0,0,0,1};

    }

    static Stream<Arguments> neighbourListProvider_Rule1(){
        return Stream.of(
                arguments(new ArrayList<>(List.of(1,1,1)), 0),
                arguments(new ArrayList<>(List.of(1,1,0)), 0),
                arguments(new ArrayList<>(List.of(1,0,1)), 0),
                arguments(new ArrayList<>(List.of(1,0,0)), 0),
                arguments(new ArrayList<>(List.of(0,1,1)), 0),
                arguments(new ArrayList<>(List.of(0,1,0)), 0),
                arguments(new ArrayList<>(List.of(0,0,1)), 0),
                arguments(new ArrayList<>(List.of(0,0,0)), 1)
                );

    }
}