import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    public void testSingleGeneration_Rule1(){
        int[] testArray = {0,0,0,0,1,1,0,1};
        int[] expectedResultArray = {1,1,1,0,0,0,0,0};

        Assertions.assertArrayEquals(expectedResultArray,Generator.generate(testArray));
    }

    @Test
    public void testMultipleGeneration_Rule1(){
        int[] testArray = {0,0,0,0,1,1,0,1};
        int[][] expectedResultArray = {
                {1,1,1,0,0,0,0,0},
                {0,0,0,0,1,1,1,1},
                {1,1,1,0,0,0,0,0},
                {0,0,0,0,1,1,1,1}};

        int[][] resultArray = new int[4][8];
        resultArray[1] = Generator.generate(testArray);
        for(int i = 1; i < 4; i++){
            resultArray[i] = Generator.generate(resultArray[i-1]);
        }
        Assertions.assertArrayEquals(expectedResultArray[0],Generator.generate(testArray));
    }
    public void testCalculateNextCell_Rule1(){

        Generator generator = new Generator();
        int[][] testArray = {{1,1,1},{1,1,0},{1,0,1},{1,0,0},{0,1,1},{0,1,0},{0,0,1},{0,0,0}};
        int[] expectedResultArray = {0,0,0,0,0,0,0,1};
        //Assertions.assertArrayEquals();
    }
}