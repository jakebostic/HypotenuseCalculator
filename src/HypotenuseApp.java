package ch17_prj1_HypotenuseCalculator;
import java.text.NumberFormat;
import ch17_prj1_HypotenuseCalculator.Validation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class HypotenuseApp extends Application {
	private TextField sideAfield;
	private TextField sideBfield;
	private TextField sideCfield;
	
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);

		Scene scene = new Scene(grid, 300, 250);

		grid.add(new Label("Side A:"), 0, 0);
		sideAfield = new TextField();
		grid.add(sideAfield, 1, 0);

		grid.add(new Label("Side B:"), 0, 1);
		sideBfield = new TextField();
		grid.add(sideBfield, 1, 1);

		grid.add(new Label("Side C:"), 0, 2);
		sideCfield = new TextField();
		sideCfield.setEditable(false);
		grid.add(sideCfield, 1, 2);

		Button calculateBtn = new Button("Calculate");
		calculateBtn.setOnAction(event -> calculateButtonClicked());

		Button exitBtn = new Button("Exit");
		exitBtn.setOnAction(event -> exitButtonClicked());

		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().add(calculateBtn);
		buttonBox.getChildren().add(exitBtn);
		buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(buttonBox, 0, 4, 2, 1);

		primaryStage.setTitle("Right Triangle Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void calculateButtonClicked() {
		Validation v = new Validation();
		String errorMsg = "";
		errorMsg += v.isDouble(sideAfield.getText(), "Side A");
		errorMsg += v.isDouble(sideBfield.getText(), "Side B");
		if (errorMsg.isEmpty()) {
			double sideA = Double.parseDouble(sideAfield.getText());
			double sideB = Double.parseDouble(sideBfield.getText());

			double sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideA, 2));

			NumberFormat sideCtotal = NumberFormat.getNumberInstance();
			sideCfield.setText(sideCtotal.format(sideC));
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Invalid Data");
			alert.setContentText(errorMsg);
			alert.showAndWait();
		}

	}

	private void exitButtonClicked() {
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);

	}

}
