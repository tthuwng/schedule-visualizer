package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Schedulizer");
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20));
		
		//Text Area
		TextArea textArea = new TextArea();
		textArea.setPrefWidth(950);
		textArea.setPrefHeight(950);
		grid.add(textArea, 0, 0);
		
		//Submit Button
		Button submitButton = new Button("Submit");
		grid.add(submitButton, 0, 1);
		
		submitButton.setOnAction(action -> {
			TextHandler runText = new TextHandler(textArea.getText());
			String[] inputText = textArea.getText().split("\"|\\s");
			int countThe = 0;
			for (int i = 0; i < inputText.length; i++) {
				if (inputText[i].equalsIgnoreCase("the")) {
					countThe++;
				}
			}
			String s = "s";
			if (countThe <= 1) {
				s = "";
			}
			String outputResult = "\"The\" appears " + countThe + " time" + s + " in the text";
			Label message = new Label (outputResult);
			StackPane window = new StackPane();
			
			Scene scene1 = new Scene(window, 1000, 1000);
			window.getChildren().add(message);
			Stage newWindow = new Stage();
			newWindow.setTitle(outputResult);
			newWindow.setScene(scene1);
			newWindow.show();
        });
		
		Scene scene = new Scene(grid, 1000, 1000);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

