package application.view;
	
import application.controller.TextHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
		TabPane tabPane = new TabPane();
		
		setTab1(tabPane);
		setTab2(tabPane);
		
		
		
		VBox vBox= new VBox(tabPane);
		Scene scene = new Scene(vBox, 500, 500);
		
		primaryStage.setScene(scene);
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.show();
		
		
	}
	
	private void setTab1(TabPane tabPane) {
		Tab tab1 = new Tab("Parse Text");
		tab1.setClosable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5));
		grid.setHgap(5);
		grid.setVgap(5);
		
		//Text Area
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(1080);
		textArea.setPrefWidth(1920);
		grid.add(textArea, 0, 1);
		
		//Submit Button
		Button submitButton = new Button("Submit");
		grid.add(submitButton, 0, 2);
		
		submitButton.setOnAction(action -> {
			TextHandler runText = new TextHandler(textArea.getText());
			
			Label message = new Label ("Calendar appear here!");
			StackPane window = new StackPane();
			
			Scene scene1 = new Scene(window, 400, 200);
			window.getChildren().add(message);
			Stage newWindow = new Stage();
			newWindow.setTitle("Calendar");
			newWindow.setScene(scene1);
			newWindow.show();
        });
		
		tab1.setContent(grid);
		tabPane.getTabs().add(tab1);
	}
	private void setTab2(TabPane tabPane) {
		Tab tab2 = new Tab("Create");
		tab2.setClosable(false);
		tabPane.getTabs().add(tab2);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
