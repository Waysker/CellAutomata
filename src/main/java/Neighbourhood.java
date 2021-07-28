import java.util.ArrayList;
import java.util.List;

public class Neighbourhood {

    final int left;
    final int right;
    final int me;

    public int getRight() {
        return right;
    }

    public int getMe() {
        return me;
    }

    public int getLeft() {
        return left;
    }

    public Neighbourhood(int left, int me, int right) {
        this.left = left;
        this.right = right;
        this.me = me;
    }
}
