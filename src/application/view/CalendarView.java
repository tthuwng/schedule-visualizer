package application.view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalendarView extends MainView{
	public CalendarView() {
		triggerCalenderView();
	}
	private void triggerCalenderView() {
		StackPane window = new StackPane();

		Scene scene1 = new Scene(window, COMPUTER_WIDTH, COMPUTER_HEIGHT);
		Stage newWindow = new Stage();
		newWindow.getIcons().add(APP_ICON);
		newWindow.setTitle("Calendar");
		newWindow.setScene(scene1);
		newWindow.show();
	}
}
