import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilsTest {

    @Test
    void testIntToBinaryArray8() {
        ArrayList<Integer> expectedArray = new ArrayList<>(List.of(0,0,0,0,1,0,0,0));
        int input = 8;
        assertEquals(expectedArray, Utils.intToRuleArray(input));

    }
}