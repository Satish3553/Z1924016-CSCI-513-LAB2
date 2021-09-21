import javafx.scene.layout.Pane;

//this class creates the 2d array "map" that the ships navigate through
public class OceanMap {
    int[][] myMap;
    int dimensions=10;
    int scale;
    int islandCount;
    Pane root;
    Ship ship;

    public OceanMap(int scale){
        myMap = new int[dimensions][dimensions];
    }

    public int[][] getMap(){
        return myMap;
    }
}
