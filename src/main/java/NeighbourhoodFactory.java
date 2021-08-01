import java.util.List;

public class NeighbourhoodFactory {

    public Neighbourhood neighbourhood(List<Integer> array, int address){
            int me;
            int right;
            int left;

            me = array.get(address);
            if(address != 0){
                left = array.get(address-1);
            } else {
                left = array.get(address);
            }
            if( address != array.size() - 1){
                right = array.get(address+1);
            } else {
                right = array.get(address);
            }

        return new Neighbourhood(left, me, right);
        }

}
