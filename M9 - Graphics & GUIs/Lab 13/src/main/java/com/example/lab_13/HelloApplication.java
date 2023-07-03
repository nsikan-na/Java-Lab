package com.example.lab_13;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

  private int total;

  @Override
  public void start(Stage stage) throws IOException {
    GridPane myGrid = new GridPane();

    Scene myScene = new Scene(myGrid, 400, 300);
    myGrid.setAlignment(Pos.CENTER);

    TextField num1Field = new TextField();
    myGrid.add(num1Field, 50, 0);

    Button addButton = new Button("+");
    myGrid.add(addButton, 100, 0);

    TextField num2Field = new TextField();
    myGrid.add(num2Field, 200, 0);

    Label totalLabel = new Label("");
    myGrid.add(totalLabel, 300, 0);

    addButton.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          total =
            Integer.parseInt(num1Field.getText()) +
            Integer.parseInt(num2Field.getText());
          totalLabel.setText("= " + total);
        }
      }
    );

    stage.setScene(myScene);
    stage.setTitle("MegaCalc");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
