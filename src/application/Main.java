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
			String[] inputText = textArea.getText().split("\n");
			int countThe = 0;
			int varCount = 0;
			
			
			for (int i = 12; i < inputText.length; i++) {
				varCount++;
			}
			
			int classAMT = varCount/11;
			String[][] schedule = new String[classAMT][12];
			varCount = 12;
			for(int c = 0; c<classAMT; c++)
			{
				for (int i = 0; i < 11; i++) {
					
					schedule[c][i] = inputText[varCount];
					varCount++;
					
					
				}
			}
			String outputResult1 = "" +schedule[0][0] + " " +schedule[0][1] + " " +schedule[0][2] + " " +schedule[0][3] + " " +schedule[0][4] + " " +schedule[0][5] +" " +schedule[0][6] + " " +schedule[0][8] + " " +schedule[0][9] + " " +schedule[0][10];
			Label message1 = new Label (outputResult1);
			String outputResult2 = "" +schedule[1][0] + " " +schedule[1][1] + " " +schedule[1][2] + " " +schedule[1][3] + " " +schedule[1][4] + " " +schedule[1][5] + " "+schedule[1][6] + " " +schedule[1][8] + " " +schedule[1][9] + " " +schedule[1][10];
			Label message2 = new Label(outputResult2);
			String outputResult3 = "" +schedule[2][0] + " " +schedule[2][1] + " " +schedule[2][2] + " " +schedule[2][3] + " " +schedule[2][4] + " " +schedule[2][5] + " " +schedule[2][6] + " "+schedule[2][8] + " " +schedule[2][9] + " " +schedule[2][10];
			Label message3 = new Label (outputResult3);
			String outputResult4 = "" +schedule[3][0] + " " +schedule[3][1] + " " +schedule[3][2] + " " +schedule[3][3] + " " +schedule[3][4] + " " +schedule[3][5] + " "+schedule[3][6] + " " +schedule[3][8] + " " +schedule[3][9] + " " +schedule[3][10];
			Label message4 = new Label(outputResult4);
			GridPane window = new GridPane();
			
			Scene scene1 = new Scene(window, 1000, 1000);
			window.add(message1, 0, 0);
			window.add(message2, 0, 1);
			window.add(message3, 0, 2);
			window.add(message4, 0, 3);
			Stage newWindow = new Stage();
			newWindow.setTitle(outputResult1);
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

