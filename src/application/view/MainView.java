package application.view;

import java.awt.Dimension;
import java.time.LocalDateTime;

import application.controller.TextHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainView extends Application {
	private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final double COMPUTER_WIDTH = screenSize.getWidth()-100;
	private final double COMPUTER_HEIGHT = screenSize.getHeight()-100;
	private final Image APP_ICON = new Image(getClass().getResourceAsStream("images/logo.png"));
	
	private final ObservableList<String> timeOptions = FXCollections.observableArrayList("AM", "PM");
	/*private Stage stage;
	private Scene startScene;

	private BorderPane root;
	private BorderPane textRoot;
	private BorderPane calendarRoot;

	private Scene textScene;
	private Scene calendarScene;*/

	@Override
	public void start(Stage primaryStage) {
		
		Scene scene = new Scene(initializeWindow(primaryStage), 500, 500);
		
		
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.show();

	}
	
	private VBox initializeWindow(Stage primaryStage) {
		primaryStage.setTitle("Schedulizer");
		primaryStage.getIcons().add(APP_ICON);
		
		GridPane titleGrid = new GridPane();
		titleGrid.getStyleClass().add("title-grid");
		Text appTitle = new Text("schedulizer");
		appTitle.setId("app-title");
		Image signatureIcon = new Image(getClass().getResourceAsStream("images/signature.png"));
		Label signatureLabel = new Label();
		ImageView signatureView = new ImageView(signatureIcon);
		signatureView.setFitHeight(50);
		signatureView.setPreserveRatio(true);
		
		signatureLabel.setGraphic(signatureView);
		titleGrid.add(signatureLabel, 0, 0);
		titleGrid.add(appTitle, 1, 0);
		
		TabPane tabPane = new TabPane();
		tabPane.getStyleClass().add("background-tab");
		setTab1(tabPane);// Parse Text Tab
		setTab2(tabPane);// Create Tab

		VBox vBox = new VBox();
		
		vBox.getChildren().add(titleGrid);
		vBox.getChildren().add(tabPane);
		return vBox;
	}

	/**
	 * setTab1 is to create the Tab of the Parse Text User can use this class to
	 * parse their schedule that they copy from their Arches.
	 * 
	 * @param tabPane
	 */
	private void setTab1(TabPane tabPane) {
		Tab tab1 = new Tab("Parse Text");
		tab1.setClosable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(5);
		tab1.getStyleClass().add("parse-text-tab");

		// Text Area
		Text instruction = new Text("Parse your schedule here, we will get your courses schedule for you");
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(1080);
		textArea.setPrefWidth(1920);
		grid.add(instruction, 0, 0);
		grid.add(textArea, 0, 1);

		// Submit Button
		Button submitButton = new Button("Schedulize");
		submitButton.getStyleClass().add("submit-button");
		grid.add(submitButton, 0, 2);

		submitButton.setOnAction(action -> {
			parseTextSchedulize(textArea);
		});

		tab1.setContent(grid);
		tabPane.getTabs().add(tab1);
	}
	
	private void parseTextSchedulize(TextArea textArea) {
		Label message = new Label();
		if (!textArea.getText().equals("")) {
			TextHandler runText = new TextHandler(textArea.getText());
			String[][] schedule = runText.getSchedule();
			String outputResult1 = "" + schedule[0][0] + " " + schedule[0][1] + " " + schedule[0][2] + " "
					+ schedule[0][3] + " " + schedule[0][4] + " " + schedule[0][5] + " " + schedule[0][6] + " "
					+ schedule[0][7] + " " + schedule[0][8] + " " + schedule[0][9] + " " + schedule[0][10] + " "
					+ schedule[0][11];

			String outputResult2 = "" + schedule[1][0] + " " + schedule[1][1] + " " + schedule[1][2] + " "
					+ schedule[1][3] + " " + schedule[1][4] + " " + schedule[1][5] + " " + schedule[1][6] + " "
					+ schedule[1][7] + " " + schedule[1][8] + " " + schedule[1][9] + " " + schedule[1][10] + " "
					+ schedule[1][11];

			String outputResult3 = "" + schedule[2][0] + " " + schedule[2][1] + " " + schedule[2][2] + " "
					+ schedule[2][3] + " " + schedule[2][4] + " " + schedule[2][5] + " " + schedule[2][6] + " "
					+ schedule[2][7] + " " + schedule[2][8] + " " + schedule[2][9] + " " + schedule[2][10] + " "
					+ schedule[2][11];

			String outputResult4 = "" + schedule[3][0] + " " + schedule[3][1] + " " + schedule[3][2] + " "
					+ schedule[3][3] + " " + schedule[3][4] + " " + schedule[3][5] + " " + schedule[3][6] + " "
					+ schedule[3][7] + " " + schedule[3][8] + " " + schedule[3][9] + " " + schedule[3][10] + " "
					+ schedule[3][11];

			message.setText(outputResult1 + "\n" + outputResult2 + "\n" + outputResult3 + "\n" + outputResult4);
		} else {
			message.setText("You entered nothing :<");
			System.out.println("HELL THIS IS A MESSAGE");
		}
		
		StackPane window = new StackPane();

		Scene scene1 = new Scene(window, COMPUTER_WIDTH, COMPUTER_HEIGHT);
		window.getChildren().add(message);
		Stage newWindow = new Stage();
		newWindow.getIcons().add(APP_ICON);
		newWindow.setTitle("Calendar");
		newWindow.setScene(scene1);
		newWindow.show();
	}

	/**
	 * setTab2 allows user to manually plug in their schedules class by class
	 * 
	 * @param tabPane
	 */
	private void setTab2(TabPane tabPane) {
		Tab tab2 = new Tab("Create");
		tab2.setClosable(false);
		tab2.getStyleClass().add("parse-text-tab2");
		
		Text instruction2 = new Text("Customize your own schedule here");
		GridPane primaryGrid = new GridPane();
		primaryGrid.setPadding(new Insets(10));
		primaryGrid.setVgap(10);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15));
		grid.setStyle("-fx-background-color: #E3DE8F; -fx-background-radius: 10px;");
		grid.setHgap(5);
		grid.setVgap(5);
		
		
		// Area to input
		Label label1 = new Label("Course Code");
		label1.setPrefWidth(100);
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
		DatePicker startDate = new DatePicker();
		grid.add(label4, 0, 3);
		grid.add(startDate, 1, 3);
		
		Label label5 = new Label("End date");
		DatePicker endDate = new DatePicker();
		grid.add(label5, 2, 3);
		grid.add(endDate, 3, 3);
		
		Label label6 = new Label("Weekdays");
		GridPane weekGrid = new GridPane();
		weekGrid.setPadding(new Insets(5));
		weekGrid.setHgap(5);
		weekGrid.setVgap(5);
		
		CheckBox sun = new CheckBox("Sun");
		CheckBox mon = new CheckBox("Mon");
		CheckBox tue = new CheckBox("Tue");
		CheckBox wed = new CheckBox("Wed");
		CheckBox thu = new CheckBox("Thu");
		CheckBox fri = new CheckBox("Fri");
		CheckBox sat = new CheckBox("Sat");
		
		grid.add(label6, 0, 4);
		weekGrid.add(sun, 0, 0);
		weekGrid.add(mon, 1, 0);
		weekGrid.add(tue, 2, 0);
		weekGrid.add(wed, 3, 0);
		weekGrid.add(thu, 4, 0);
		weekGrid.add(fri, 5, 0);
		weekGrid.add(sat, 6, 0);
		
		grid.add(weekGrid, 1, 4, 3, 1);
		
		GridPane startTimeGrid = new GridPane();
		Label label7 = new Label("Start time");
		TextField startTime = new TextField();
		ComboBox timeOption1 = new ComboBox(timeOptions);
		startTime.setMaxWidth(60);
		timeOption1.setMaxWidth(70);
		grid.add(label7, 0, 5);
		startTimeGrid.add(startTime, 0, 0);
		startTimeGrid.add(timeOption1, 1, 0);
		grid.add(startTimeGrid, 1, 5);
		
		GridPane endTimeGrid = new GridPane();
		Label label8 = new Label("End time");
		ComboBox timeOption2 = new ComboBox(timeOptions);
		TextField endTime = new TextField();
		endTime.setMaxWidth(60);
		timeOption2.setMaxWidth(70);
		grid.add(label8, 2, 5);
		endTimeGrid.add(endTime, 0, 0);
		endTimeGrid.add(timeOption2, 1, 0);
		grid.add(endTimeGrid, 3, 5);
		
		Label label9 = new Label("Location");
		TextField location = new TextField();
		grid.add(label9, 0, 6);
		grid.add(location, 1, 6);
		
		Label label10 = new Label("Room No.");
		TextField roomNumber = new TextField();
		grid.add(label10, 0, 7);
		grid.add(roomNumber, 1, 7);
		
		Label label11 = new Label("Faculty");
		TextField facultyName = new TextField();
		grid.add(label11, 0, 8);
		grid.add(facultyName, 1, 8);
	
		//Add Prompt Texts into text field boxes
		courseCode.setPromptText("REGL-100");
		courseTitle.setPromptText("Intro to Ethics");
		courseCredits.setPromptText("2");
		startTime.setPromptText("9:00");
		endTime.setPromptText("10:00");
		location.setPromptText("Old Main");
		roomNumber.setPromptText("209");
		facultyName.setPromptText("Dr. Abbe");
		
		Button addCourseButton = new Button("Add Course");
		addCourseButton.getStyleClass().add("add-course-button");
		
		Button submitButtonCreate = new Button("Schedulize");
		submitButtonCreate.getStyleClass().add("submit-button");
		
		primaryGrid.add(instruction2, 0, 0);
		primaryGrid.add(grid, 0, 1);
		
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.BOTTOM_LEFT);
		hBox.getChildren().add(addCourseButton);
		hBox.getChildren().add(submitButtonCreate);
		
		primaryGrid.add(hBox, 0, 2);
		
		tab2.setContent(primaryGrid);
		tabPane.getTabs().add(tab2);
		
		addCourseButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
				}
	});
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
