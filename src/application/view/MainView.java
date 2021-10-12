package application.view;
	
import application.controller.TextHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
		
		setTab1(tabPane);// Parse Text Tab
		setTab2(tabPane);// Create Tab
		
		
		
		VBox vBox= new VBox(tabPane);
		Scene scene = new Scene(vBox, 500, 500);
		
		primaryStage.setScene(scene);
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.show();
		
		
	}
	/**
	 * setTab1 is to create the Tab of the Parse Text
	 * User can use this class to parse their schedule that they copy from their Arches.
	 * 
	 * @param tabPane
	 */
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
			String[][] schedule = runText.getSchedule();
			String outputResult1 = "" +schedule[0][0] + " " +schedule[0][1] + " " +schedule[0][2] + " " +schedule[0][3] + " " +schedule[0][4] + " " +schedule[0][5] +" " +schedule[0][6] + " " +schedule[0][8] + " " +schedule[0][9] + " " +schedule[0][10];
			
			String outputResult2 = "" +schedule[1][0] + " " +schedule[1][1] + " " +schedule[1][2] + " " +schedule[1][3] + " " +schedule[1][4] + " " +schedule[1][5] + " "+schedule[1][6] + " " +schedule[1][8] + " " +schedule[1][9] + " " +schedule[1][10];
			
			String outputResult3 = "" +schedule[2][0] + " " +schedule[2][1] + " " +schedule[2][2] + " " +schedule[2][3] + " " +schedule[2][4] + " " +schedule[2][5] + " " +schedule[2][6] + " "+schedule[2][8] + " " +schedule[2][9] + " " +schedule[2][10];
			
			String outputResult4 = "" +schedule[3][0] + " " +schedule[3][1] + " " +schedule[3][2] + " " +schedule[3][3] + " " +schedule[3][4] + " " +schedule[3][5] + " "+schedule[3][6] + " " +schedule[3][8] + " " +schedule[3][9] + " " +schedule[3][10];
			
			
			Label message = new Label (outputResult1 + "\n" + outputResult2 + "\n" + outputResult3 + "\n" + outputResult4);
			StackPane window = new StackPane();
			
			Scene scene1 = new Scene(window, 1500, 800);
			window.getChildren().add(message);
			Stage newWindow = new Stage();
			newWindow.setTitle("Calendar");
			newWindow.setScene(scene1);
			newWindow.show();
        });
		
		tab1.setContent(grid);
		tabPane.getTabs().add(tab1);
	}
	
	/**
	 * setTab2 allows user to manually plug in their schedules class by class
	 * 
	 * @param tabPane
	 */
	private void setTab2(TabPane tabPane) {
		Tab tab2 = new Tab("Create");
		tab2.setClosable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5));
		grid.setHgap(5);
		grid.setVgap(5);
		
		// Area to input
		Label label1 = new Label("Course Code");
		TextField courseCode = new TextField();
		grid.add(label1, 0, 0);
		grid.add(courseCode, 1, 0);
		
		Label label2 = new Label("Title");
		TextField courseTitle = new TextField();
		grid.add(label2, 0, 1);
		grid.add(courseTitle, 1, 1);
		
		Label label3 = new Label("Credit#");
		TextField courseCredits = new TextField();
		grid.add(label3, 0, 2);
		grid.add(courseCredits, 1, 2);
		
		Label label4 = new Label("Start date");
		TextField startDate = new TextField();
		grid.add(label4, 0, 3);
		grid.add(startDate, 1, 3);
		
		Label label5 = new Label("End date");
		TextField endDate = new TextField();
		grid.add(label5, 2, 3);
		grid.add(endDate, 3, 3);
		
		Group weekdays = new Group();
		
		CheckBox sun = new CheckBox("Sun");
		CheckBox mon = new CheckBox("Mon");
		CheckBox tue = new CheckBox("Tue");
		CheckBox wed = new CheckBox("Wed");
		CheckBox thu = new CheckBox("Thu");
		CheckBox fri = new CheckBox("Fri");
		CheckBox sat = new CheckBox("Sat");

		weekdays.getChildren().add(sun);
		weekdays.getChildren().add(mon);
		weekdays.getChildren().add(tue);
		weekdays.getChildren().add(wed);
		weekdays.getChildren().add(thu);
		weekdays.getChildren().add(fri);
		weekdays.getChildren().add(sat);
		
		grid.add(weekdays, 1, 4);
		
		tab2.setContent(grid);
		tabPane.getTabs().add(tab2);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
