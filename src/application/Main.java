package application;
	
import java.io.InputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Setting up the window
		primaryStage.setTitle("Schedulizer");
		/**
		InputStream iconStream = getClass().getResourceAsStream("/icon.png"); //Adding icon for the app
		Image image = new Image(iconStream);
		primaryStage.getIcons().add(image);**/
		
		GridPane grid = new GridPane();
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		// Changed view sizes
		Scene scene = new Scene(grid, 300, 200);
		// To link with the application.css
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);

		
		
		TextArea schedule = new TextArea();
		
		
		schedule.setPrefWidth(950);
		schedule.setPrefHeight(950);
		
	      
		grid.add(schedule, 0, 0);
		
		Button submit = new Button("Submit");
		grid.add(submit, 0, 1);
		
		
			
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event)
			{
				

				StackPane secondaryLayout = new StackPane();
				int count = 0;
				//Added \" for the case of the word The appear right after a quote mark
				String[] s = schedule.getText().split("\"|\\s");
				for(int i = 0; i < s.length; i++)
				{
					if(s[i].equalsIgnoreCase("the"))
					{
						count++;
					}
				}
				

				Scene scene1 = new Scene(secondaryLayout, 200, 100);
				Stage newWindow = new Stage();
				Label secondLabel = new Label("'The' appears "+ count+ " many times!");
				
				secondaryLayout.getChildren().add(secondLabel);
				newWindow.setTitle("Second Stage");
				newWindow.setScene(scene1);
				newWindow.show();
			}
		
		});
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

