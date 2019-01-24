package ga222gb_assign3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application{
    public Line line;
    public Rectangle rec;
    public Circle circle;
    public double x;
    public double y;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Pane layout = new Pane();
        Scene scene = new Scene(layout, 1000, 600);

        ComboBox<String> shape = new ComboBox<>();
        shape.relocate(5, 5);
        shape.getItems().addAll(
                "Line",
                "Dot",
                "Rectangle",
                "Circle"
        );

        ComboBox<String> size = new ComboBox<>();
        size.relocate(125, 5);
        size.getItems().addAll(
                "1",
                "2",
                "5",
                "10",
                "15",
                "20",
                "25",
                "30",
                "35",
                "40"
        );

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.relocate(200, 5);

        layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getX();
                y = event.getY();
                if(shape.getSelectionModel().getSelectedIndex() == 0){
                    int lineWidth = Integer.parseInt(size.getSelectionModel().getSelectedItem());
                    line = new Line();
                    line.setStrokeWidth(lineWidth);
                    line.setStroke(colorPicker.getValue());
                    line.relocate(x, y);
                    layout.getChildren().addAll(line);
                }else if(shape.getSelectionModel().getSelectedIndex() == 1){
                    int dotSize = Integer.parseInt(size.getSelectionModel().getSelectedItem());
                    rec = new Rectangle(dotSize, dotSize);
                    rec.setFill(colorPicker.getValue());
                    rec.relocate(x, y);
                    layout.getChildren().addAll(rec);
                } else if(shape.getSelectionModel().getSelectedIndex() == 2){
                    rec = new Rectangle();
                    rec.relocate(x, y);
                    rec.setFill(colorPicker.getValue());
                    layout.getChildren().addAll(rec);
                }else if(shape.getSelectionModel().getSelectedIndex() == 3){
                    circle = new Circle();
                    circle.relocate(x, y);
                    circle.setFill(colorPicker.getValue());
                    layout.getChildren().addAll(circle);
                }
            }
        });

        layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(shape.getSelectionModel().getSelectedIndex() == 0){
                    line.setEndX(event.getX() - x);
                    line.setEndY(event.getY() - y);
                }else if(shape.getSelectionModel().getSelectedIndex() == 2){
                    rec.setHeight(event.getY() - y);
                    rec.setWidth(event.getX() - x);
                }else if(shape.getSelectionModel().getSelectedIndex() == 3){
                    circle.setRadius(event.getX() - x);
                }
            }
        });

        layout.getChildren().addAll(shape, size, colorPicker);
        scene.setFill(Color.LIGHTGREY);
        primaryStage.setTitle("Tiny Painter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
