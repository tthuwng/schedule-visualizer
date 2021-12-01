package application.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.*;
import com.calendarfx.view.page.WeekPage;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.application.Platform;
import application.model.Course;

public class CalendarMainView extends MainView {

	private static Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected final static double COMPUTER_WIDTH = screenSize.getWidth()-100;
	protected final static double COMPUTER_HEIGHT = screenSize.getHeight()-100;
	
	public static String[] getWeekDayName(String[] list ) {
		String[] newList = new String[list.length];
		
		for (int i = 0; i < list.length; i++) {
			String dayName = "";
			switch (list[i]) {
	            case "M": dayName = "MO"; break;
	            case "W": dayName = "WE"; break;
	            case "F": dayName = "FR"; break;
	            case "Tu": dayName = "TU"; break;
	            case "Th": dayName = "TH"; break;
	            default:dayName = "Invalid day range";
			}
			newList[i] = dayName;
		}
       return newList;
    }

	public static void triggerCalenderView(ArrayList<Course> courses) {

		CalendarView calendarView = new CalendarView();
		Calendar mainCalendar = new Calendar("Main");
		mainCalendar.setStyle(Style.STYLE1);
     

		// Main engine calendarfx
		for (Course course: courses) {
			Entry<String> classEvent = new Entry<>(course.getTitle());
			classEvent.setLocation(course.getLocation());
			LocalDate startDate = LocalDate.parse(course.getStartDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
			String endDate = LocalDate.parse(course.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu")).format(DateTimeFormatter.BASIC_ISO_DATE);
			classEvent.setInterval(startDate);
			if (course.getStartTime() != "" && course.getEndTime() != "") {
			    LocalTime start = LocalTime.parse(course.getStartTime(), DateTimeFormatter.ofPattern("h:mma"));
				LocalTime end = LocalTime.parse(course.getEndTime(), DateTimeFormatter.ofPattern("h:mma"));
				
				classEvent.setInterval(start, end);
			}
			
			if (course.getWeekdaysList() != null) {
				String[] weekDayList = getWeekDayName(course.getWeekdaysList());
				String weekDayListString = Arrays.toString(weekDayList).replace("[", "").replace("]", "").replace(" ", "");
				classEvent.setRecurrenceRule("RRULE:FREQ=WEEKLY;BYDAY="+ weekDayListString +";UNTIL=" + endDate + ";");
			}
			
			
			
            mainCalendar.addEntry(classEvent);

		}



		CalendarSource myCalendarSource = new CalendarSource("My Calendars");
		myCalendarSource.getCalendars().addAll(mainCalendar);

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
