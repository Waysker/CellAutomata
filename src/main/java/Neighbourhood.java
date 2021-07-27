import java.util.ArrayList;

public class Neighbourhood {

    Integer left, right, me;

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getMe() {
        return me;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
    Neighbourhood(){

    }
    Neighbourhood(ArrayList<Integer> array, int place){
        me = array.get(place);
        if(place != 0){
            left = array.get(place-1);
        } else {
            left = 0;
        }
        if( place != array.size() - 1){
            right = array.get(place+1);
        } else {
            right = 0;
        }
    }

}
