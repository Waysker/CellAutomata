import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    void testIntToBinaryArray8() {
        int[][] expectedArray = {
                {0,0,0,0,1,0,0,0},
                {1,0,1,0,1,1,0,1},
                {1,1,1,1,1,1,1,1},
                {1,0,0,0,1,0,0,1}};
        int[] input = {8, 173, 255, 137};

        for (int i = 0; i < input.length; i++) {
            assertArrayEquals(expectedArray[i], Utils.intToBinaryArray8(input[i]));
        }

    }
}