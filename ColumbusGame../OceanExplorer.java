
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application {

    int[][] islandMap;
    int count;
    final int dimensions = 25;
    final int scale = 20;
    final int islandCount = 10;
    Scene scene;
    Pane root;
    OceanMap oceanMap;
    Ship ship;
    ImageView shipImageView;
    ImageView pImageView;
    ImageView p1ImageView;
    Label moves;

    @Override
    public void start(final Stage oceanStage) throws Exception {
  
        oceanMap = new OceanMap(scale);
        islandMap = oceanMap.getMap();

        root = new AnchorPane();
        drawMap();
        

        moves.setLayoutX(100);
        moves.setLayoutY(500);
        root.getChildren().add(moves);

        //setting the scene
        scene = new Scene(root, 500, 526);
        oceanStage.setTitle("Christopher Columbus Sails the Ocean Blue");
        oceanStage.setScene(scene);
        oceanStage.show();

        startSailing();

    }

    //draws 25X25 grid
    public void drawMap(){
        for(int x = 0; x < dimensions; x++){
            for(int y = 0; y < dimensions; y++){
                Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.PALETURQUOISE);
                //add to the node tree in the pane
                root.getChildren().add(rect);
            }
        }
    }

    //loads image of ship
    public void loadShipImage(){
        Image shipImage = new Image("file:images/ship.png",20,20,true,true);
        shipImageView = new ImageView(shipImage);
        shipImageView.setX(ship.getShipLocation().x * scale);
        shipImageView.setY(ship.getShipLocation().y * scale);
        root.getChildren().add(shipImageView);
    }





    //responds to key events
    private void startSailing(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke) {
                switch(ke.getCode()){
                    case RIGHT:
                        ship.move("EAST");
                        break;
                    case LEFT:
                        ship.move("WEST");
                        break;
                    case UP:
                        ship.move("NORTH");
                        break;
                    case DOWN:
                        ship.move("SOUTH");
                        break;
                    default:
                        break;
                }
 
                shipImageView.setX(ship.getShipLocation().x*scale);
                shipImageView.setY(ship.getShipLocation().y*scale);

            }});
    }


    public static void main(String[] args) {
        launch(args);
    }

}
