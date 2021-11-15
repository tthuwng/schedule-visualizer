package application.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.application.Platform;

public class CalendarMainView extends MainView {
//	public CalendarMainView() {
//		triggerCalenderView();
//	}
	private static Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected final static double COMPUTER_WIDTH = screenSize.getWidth()-100;
	protected final static double COMPUTER_HEIGHT = screenSize.getHeight()-100;

	public static void triggerCalenderView() {

		CalendarView calendarView = new CalendarView();
		Calendar main = new Calendar("Main");
		main.setStyle(Style.STYLE1);

		CalendarSource myCalendarSource = new CalendarSource("My Calendars");
		myCalendarSource.getCalendars().addAll(main);

		calendarView.getCalendarSources().addAll(myCalendarSource);

		calendarView.setRequestedTime(LocalTime.now());

		Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
			@Override
			public void run() {
				while (true) {
					Platform.runLater(() -> {
						calendarView.setToday(LocalDate.now());
						calendarView.setTime(LocalTime.now());
					});

					try {
						// update every 10 seconds
						sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			};
		};

		updateTimeThread.setPriority(Thread.MIN_PRIORITY);
		updateTimeThread.setDaemon(true);
		updateTimeThread.start();
		
		StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(calendarView);

		Scene scene1 = new Scene(stackPane, COMPUTER_WIDTH, COMPUTER_HEIGHT);
		Stage newWindow = new Stage();
//		newWindow.getIcons().add(APP_ICON);
		newWindow.setTitle("Calendar");
		newWindow.setScene(scene1);
		newWindow.show();
	}
	
	
}
