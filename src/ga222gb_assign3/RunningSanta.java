package ga222gb_assign3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningSanta extends Application{
    public int x_speed = 6;
    public int imageCounter = 0;
    public int width = 1000;
    public int height = 500;
    public int santaWidth = 200;
    public int santaHeight = 150;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Group layout = new Group();

        Image background = new Image(getClass().getResourceAsStream("images/BG.png"));
        Image[] images = new Image[11];
        images[0] = new Image(getClass().getResourceAsStream("images/Run (1).png"));
        images[1] = new Image(getClass().getResourceAsStream("images/Run (2).png"));
        images[2] = new Image(getClass().getResourceAsStream("images/Run (3).png"));
        images[3] = new Image(getClass().getResourceAsStream("images/Run (4).png"));
        images[4] = new Image(getClass().getResourceAsStream("images/Run (5).png"));
        images[5] = new Image(getClass().getResourceAsStream("images/Run (6).png"));
        images[6] = new Image(getClass().getResourceAsStream("images/Run (7).png"));
        images[7] = new Image(getClass().getResourceAsStream("images/Run (8).png"));
        images[8] = new Image(getClass().getResourceAsStream("images/Run (9).png"));
        images[9] = new Image(getClass().getResourceAsStream("images/Run (10).png"));
        images[10] = new Image(getClass().getResourceAsStream("images/Run (11).png"));

        ImageView bg = new ImageView(background);
        bg.setFitHeight(height);
        bg.setFitWidth(width);

        Image santa = new Image(getClass().getResourceAsStream("images/Run (1).png"));
        ImageView s = new ImageView(santa);
        s.setFitWidth(santaWidth);
        s.setFitHeight(santaHeight);
        s.setX(400);
        s.setY(223);

        layout.getChildren().addAll(bg, s);

        Scene scene = new Scene(layout, 1000, 500);
        primaryStage.setTitle("Running Santa");
        primaryStage.setScene(scene);
        primaryStage.show();

        KeyFrame k = new KeyFrame(Duration.millis(40), event -> {
            if(imageCounter == 11){
                imageCounter = 0;
            }
            s.setImage(images[imageCounter++]);

            s.setX(s.getX() + x_speed);

            if(s.getX() <= 0 || s.getX() >= width - santaWidth){
                x_speed = -x_speed;
            }

            if(x_speed < 0){
                s.setScaleX(-1);
            }else{
                s.setScaleX(1);
            }
        });

        Timeline t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
