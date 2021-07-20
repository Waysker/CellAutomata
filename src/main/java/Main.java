import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {0,0,0,1,0,0,0,0};
        //int[] nextArray = new int[array.length];
        for(int i = 0; i < 10; i++){
            System.out.println(Arrays.toString(array));
            array = Generator.generate(array, 3);


        }
    }
}
