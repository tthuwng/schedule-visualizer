package application.view;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.controller.TextHandler;
import application.model.Course;
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
	protected final double COMPUTER_WIDTH = screenSize.getWidth()-100;
	protected final double COMPUTER_HEIGHT = screenSize.getHeight()-100;
	protected final Image APP_ICON = new Image(getClass().getResourceAsStream("images/logo.png"));
	
	
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
		Tab1 newTab1 = new Tab1(tabPane);
		Tab2 newTab2 = new Tab2(tabPane);

		VBox vBox = new VBox();
		
		vBox.getChildren().add(titleGrid);
		vBox.getChildren().add(tabPane);
		return vBox;
	}

	
		
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
