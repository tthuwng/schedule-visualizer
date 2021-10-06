package application.view;
	
import application.controller.TextHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;

public class MainView extends Application {
	private Stage stage;
	private Scene startScene;
	
	private BorderPane root;
	private BorderPane textRoot;
	private BorderPane calendarRoot;
	
	private Scene textScene;
	private Scene calendarScene;
	
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Schedulizer");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		
		//Text Area
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(1080);
		textArea.setPrefWidth(1920);
		grid.add(textArea, 0, 0);
		
		//Submit Button
		Button submitButton = new Button("Submit");
		grid.add(submitButton, 0, 1);
		
		submitButton.setOnAction(action -> {
			TextHandler runText = new TextHandler(textArea.getText());
			
			Label message = new Label ("Calendar appear here!");
			StackPane window = new StackPane();
			
			Scene scene1 = new Scene(window, 400, 200);
			window.getChildren().add(message);
			Stage newWindow = new Stage();
			newWindow.setTitle("jn");
			newWindow.setScene(scene1);
			newWindow.show();
        });
		
		Scene scene = new Scene(grid, 500, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
