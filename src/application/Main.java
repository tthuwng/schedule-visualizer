package application;
	
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 1000, 1000);
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
				String[] s = schedule.getText().split("\\s");
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

