//package JavaFx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;



public class CircleSize extends Application {
    private CirclePane circlePane= new CirclePane();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane bpane = new BorderPane();
        StackPane spane=new StackPane();
        HBox hb = new HBox(10);
        bpane.setCenter(spane);
        hb.setAlignment(Pos.CENTER);
        bpane.setBottom(hb);

        spane.getChildren().add(circlePane);
        Button shrink = new Button("shrink");
        Button enlarge = new Button("enlarge");
        shrink.setOnAction(new ShrinkHandler());
        enlarge.setOnAction(new EnlargeHandler());
        hb.getChildren().addAll(shrink, enlarge);

        Scene scene = new Scene(bpane, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle Size Changes");
        primaryStage.show();
    }
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.enlarge();
        }
    }
    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        }
    }
}
class CirclePane extends StackPane{
   private Circle circle = new Circle(50);
       public CirclePane() {
           this.getChildren().add(circle);
           circle.setStroke(Color.BLACK);
           circle.setFill(Color.LIGHTBLUE);
       }
       public void enlarge(){
           circle.setRadius(circle.getRadius()+10);
       }
       public void shrink(){
           circle.setRadius(circle.getRadius()-2);
       }

}
