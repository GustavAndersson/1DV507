package ga222gb_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class Yahtzee extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public int rolls = 3;
    public Image one = new Image(getClass().getResourceAsStream("dice/one.png"));
    public Image two = new Image(getClass().getResourceAsStream("dice/two.png"));
    public Image three = new Image(getClass().getResourceAsStream("dice/three.png"));
    public Image four = new Image(getClass().getResourceAsStream("dice/four.png"));
    public Image five = new Image(getClass().getResourceAsStream("dice/five.png"));
    public Image six = new Image(getClass().getResourceAsStream("dice/six.png"));
    public int[] values = new int[5];

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Yahtzee");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        ImageView oneView = new ImageView(one);
        pane.add(oneView, 0,0);
        CheckBox boxOne = new CheckBox();
        pane.add(boxOne, 0, 1);
        boxOne.setDisable(true);

        ImageView twoView = new ImageView(two);
        pane.add(twoView, 1, 0);
        CheckBox boxTwo = new CheckBox();
        pane.add(boxTwo, 1, 1);
        boxTwo.setDisable(true);

        ImageView threeView = new ImageView(three);
        pane.add(threeView, 2, 0);
        CheckBox boxThree = new CheckBox();
        pane.add(boxThree, 2, 1);
        boxThree.setDisable(true);

        ImageView fourView = new ImageView(four);
        pane.add(fourView, 3, 0);
        CheckBox boxFour = new CheckBox();
        pane.add(boxFour, 3, 1);
        boxFour.setDisable(true);

        ImageView fiveView = new ImageView(five);
        pane.add(fiveView, 4, 0);
        CheckBox boxFive = new CheckBox();
        pane.add(boxFive, 4, 1);
        boxFive.setDisable(true);

        final Label rollsLeft = new Label();
        rollsLeft.setText("You have 3 rolls left.");
        pane.add(rollsLeft, 1, 4);

        Button roll = new Button("Roll the dice!");
        pane.add(roll, 0, 4);
        GridPane.setHalignment(roll, HPos.LEFT);
        roll.setOnAction(e -> {
            rolls--;
            if(rolls >= 0){
                System.out.println(rolls);
                boxOne.setDisable(false);
                boxTwo.setDisable(false);
                boxThree.setDisable(false);
                boxFour.setDisable(false);
                boxFive.setDisable(false);
                if(!boxOne.isSelected()){
                    Image temp = getImage(1);
                    oneView.setImage(temp);
                }
                if(!boxTwo.isSelected()){
                    Image temp = getImage(2);
                    twoView.setImage(temp);
                }
                if(!boxThree.isSelected()){
                    Image temp = getImage(3);
                    threeView.setImage(temp);
                }
                if(!boxFour.isSelected()){
                    Image temp = getImage(4);
                    fourView.setImage(temp);
                }
                if(!boxFive.isSelected()){
                    Image temp = getImage(5);
                    fiveView.setImage(temp);
                }
                rollsLeft.setText("You have " + rolls + " roll(s) left.");
            }

            if(rolls == 0){
                rollsLeft.setText(displayResult());
            }
        });

        Scene scene = new Scene(pane, 700, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Image getImage(int diceNumber){
        Random r = new Random();
        int val = r.nextInt(6) + 1;
        Image temp = null;
        switch (val){
            case 1: temp = one;
                break;
            case 2: temp = two;
                break;
            case 3: temp = three;
                break;
            case 4: temp = four;
                break;
            case 5: temp = five;
                break;
            case 6: temp = six;
                break;
            default: System.out.println("Error");
                break;
        }
        values[diceNumber - 1] = val;
        return temp;
    }

    public String displayResult(){

        //Check if yahtzee
        for(int i = 1; i <= 6; i++){
            int counter = 0;
            for (int j = 0; j < 5; j++){
                if(values[j] == i){
                    counter++;
                }
                if(counter > 4){
                    return "Yahtzee!";
                }
            }
        }

        //Check if four of a kind
        for(int i = 1; i <= 6; i++){
            int counter = 0;
            for (int j = 0; j < 5; j++){
                if(values[j] == i){
                    counter++;
                }
                if(counter > 3){
                    return "Four of a kind";
                }
            }
        }

        //Check if three of a kind
        boolean threeOfAKind = false; //boolean for further use (full house)
        for(int i = 1; i <= 6; i++){
            int counter = 0;
            for (int j = 0; j < 5; j++){
                if(values[j] == i){
                    counter++;
                }
                if(counter > 2){
                    threeOfAKind = true;
                }
            }
        }

        //Sort array to facilitate upcoming calculations
        Arrays.sort(values);

        //If there are three of a kind, check if Full House. If not - printout three of a kind.
        if(threeOfAKind){
            if(values[0] == values[1] && values[3] == values[4]){
                return "Full House";
            }
            return "Three of a kind";
        }


        //Check if Large Straight
        if((values[0] == 1 && values[1] == 2 && values[2] == 3 && values[3] == 4 && values[4] == 5) ||
                (values[0] == 2) && values[1] == 3 && values[2] == 4 && values[3] == 5 && values[4] == 6) {
                    return "Large Straight";
        }

        //Check if Small Straight
        if((values[0] == 1 && values[1] == 2 && values[2] == 3 && values[3] == 4) ||
            (values[1] == 2 && values[2] == 3 && values[3] == 4 && values[4] == 5) ||
                (values[2] == 3 && values[3] == 4 && values[4] == 5 && values[5] == 6)) {
                    return "Small Straight";
        }

        //Check if pair
        for(int i = 1; i <= 6; i++){
            int counter = 0;
            for (int j = 0; j < 5; j++){
                if(values[j] == i){
                    counter++;
                }
                if(counter > 1){
                    return "Pair";
                }
            }
        }

        return "No combinations";
    }
}
