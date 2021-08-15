import java.util.List;

public class Configuration {
    private final List<Integer> initList;
    private final int screenWidth;
    private final int screenHeight;

    public Configuration()
    {
        this.screenHeight = 920;
        this.screenWidth = 1080;
        this.initList = List.of(0,0,0,0,0,1,0,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,0,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,1,0,0,0
                ,0,0,0,0,0,0,1,0,0,0);
    }

    public List<Integer> getInitList() {
        return initList;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
