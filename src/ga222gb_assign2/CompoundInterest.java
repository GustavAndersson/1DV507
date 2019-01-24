package ga222gb_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class CompoundInterest extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Compound Interest");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(new Text("Compound Interest"), 0, 0);

        pane.add(new Label("Start amount:"), 0, 1);
        final TextField textAmount = new TextField();
        pane.add(textAmount, 1, 1);

        pane.add(new Label("Interest"), 0, 2);
        final TextField textInterest = new TextField();
        pane.add(textInterest, 1, 2);

        pane.add(new Label("Number of years:"), 0, 3);
        final TextField textYears = new TextField();
        pane.add(textYears, 1, 3);

        final Label result = new Label();
        pane.add(result, 0, 5);

        Button calculate = new Button("Calculate");
        pane.add(calculate, 0, 4);
        GridPane.setHalignment(calculate, HPos.LEFT);
        calculate.setOnAction(e -> {
            double amount = Double.parseDouble(textAmount.getText());
            double interest = Double.parseDouble(textInterest.getText()) / 100;
            double years = Double.parseDouble(textYears.getText());
            double total = amount * Math.pow((1 + interest), years);
            DecimalFormat df = new DecimalFormat("0");
            String format = df.format(total);
            result.setText("In total that will be " + format);
        });

        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
