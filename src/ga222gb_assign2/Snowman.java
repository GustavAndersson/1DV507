package ga222gb_assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Snowman extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Circle c1 = new Circle (320, 340, 50);
        c1.setFill(Color.WHITE);

        Circle c2 = new Circle (320, 270, 30);
        c2.setFill(Color.WHITE);

        Circle c3 = new Circle (320, 225, 20);
        c3.setFill(Color.WHITE);

        Circle sun = new Circle(520, 100, 55);
        sun.setFill(Color.YELLOW);

        Circle button1 = new Circle(320, 285, 3);
        Circle button2 = new Circle(320, 270, 3);
        Circle button3 = new Circle(320, 255, 3);

        Circle eye1 = new Circle(312, 220, 3);
        Circle eye2 = new Circle(328, 220, 3);

        Line mouth = new Line(315, 230, 325, 230);

        Rectangle ground = new Rectangle(0, 380, 640, 100);
        ground.setFill(Color.WHITE);

        root.getChildren().addAll(c1, c2, c3, button1, button2, button3, eye1, eye2, mouth, sun, ground);

        Scene scene = new Scene(root, 640, 480);
        scene.setFill(Color.DEEPSKYBLUE);
        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
