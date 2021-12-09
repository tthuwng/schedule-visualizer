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
	/**
	 * Gets the week day names
	 * 
	 * @param list The list of week days 
	 * @return String[] Returns the new week day list
	 */
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
	
	private static boolean hasOverLapTime(LocalTime startT1, LocalTime endT1, LocalTime startT2, LocalTime endT2) {
		return !endT1.isBefore(startT2) && !startT1.isAfter(endT2);
	}
	
	private static boolean hasOverLapDate(LocalDate startT1, LocalDate endT1, LocalDate startT2, LocalDate endT2) {
		return !endT1.isBefore(startT2) && !startT1.isAfter(endT2);
	}

	public static void triggerCalenderView(ArrayList<Course> courses) {
		
		Set<Course> mainCourse = new HashSet<Course>();
		Set<Course> conflictCourse = new HashSet<Course>();

		CalendarView calendarView = new CalendarView();
		Calendar mainCalendar = new Calendar("Main");
		mainCalendar.setStyle(Style.STYLE1);
		
		Calendar conflictCalendar = new Calendar("Conflict");
		conflictCalendar.setStyle(Style.STYLE5);
	
		
		for (int i = 0; i < courses.size(); i++) {
			
			for (int j = i+1; j <courses.size(); j++) {
				//TODO: fix loop optimization
//				if (conflictCourse.contains(courses.get(i))) {
//					
//					break;
//				}
				if (courses.get(i).getStartTime() != "" && courses.get(i).getEndTime() != "") {
					LocalTime startTime = LocalTime.parse(courses.get(i).getStartTime(), DateTimeFormatter.ofPattern("h:mma"));
					LocalTime endTime = LocalTime.parse(courses.get(i).getEndTime(), DateTimeFormatter.ofPattern("h:mma"));
					
					LocalDate startDate = LocalDate.parse(courses.get(i).getStartDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
					LocalDate endDate = LocalDate.parse(courses.get(i).getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
					if (Arrays.equals(courses.get(i).getWeekdaysList(), courses.get(j).getWeekdaysList())
							&& hasOverLapDate(startDate, endDate, LocalDate.parse(courses.get(j).getStartDate(), DateTimeFormatter.ofPattern("MM/dd/uu")), LocalDate.parse(courses.get(j).getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu")))
							&& hasOverLapTime(startTime, endTime, LocalTime.parse(courses.get(j).getStartTime(), DateTimeFormatter.ofPattern("h:mma")), LocalTime.parse(courses.get(j).getEndTime(), DateTimeFormatter.ofPattern("h:mma")))) {
						conflictCourse.add(courses.get(i));
						conflictCourse.add(courses.get(j));
						break;
					}
				}
			}
			if (!conflictCourse.contains(courses.get(i))) {
				mainCourse.add(courses.get(i));
			}
		}

		
		for (Course course : mainCourse) {
			Entry<String> classEvent = new Entry<>(course.getCourseCode()  + ": " + course.getTitle());
			classEvent.setLocation(
					"Location: " +  course.getLocation() + "Faculty: " + course.getFaculty());
			LocalDate startDate = LocalDate.parse(course.getStartDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
			LocalDate endDate = LocalDate.parse(course.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
			String endDateString = LocalDate.parse(course.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu")).format(DateTimeFormatter.BASIC_ISO_DATE);
			classEvent.setInterval(startDate);
			
			
			if (course.getStartTime() != "" && course.getEndTime() != "") {
			    LocalTime startTime = LocalTime.parse(course.getStartTime(), DateTimeFormatter.ofPattern("h:mma"));
				LocalTime endTime = LocalTime.parse(course.getEndTime(), DateTimeFormatter.ofPattern("h:mma"));
				
				classEvent.setInterval(startTime, endTime);
			} else {
				classEvent.setFullDay(true);
				classEvent.setInterval(startDate, endDate);
				
			}
			
			if (course.getWeekdaysList() != null) {
				String[] weekDayList = getWeekDayName(course.getWeekdaysList());
				String weekDayListString = Arrays.toString(weekDayList).replace("[", "").replace("]", "").replace(" ", "");
				classEvent.setRecurrenceRule("RRULE:FREQ=WEEKLY;BYDAY="+ weekDayListString +";UNTIL=" + endDateString + ";");
			}
			mainCalendar.addEntry(classEvent);
		}
		
		// conflictCourse
		
		for (Course course : conflictCourse) {
			Entry<String> classEvent = new Entry<>(course.getCourseCode()  + ": " + course.getTitle());
			classEvent.setLocation(course.getLocation() != "" ?  "Location: " +  course.getLocation() + " - " : " " + course.getFaculty() != "" ? "Faculty: " + course.getFaculty() : "");
			LocalDate startDate = LocalDate.parse(course.getStartDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
			LocalDate endDate = LocalDate.parse(course.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu"));
			String endDateString = LocalDate.parse(course.getEndDate(), DateTimeFormatter.ofPattern("MM/dd/uu")).format(DateTimeFormatter.BASIC_ISO_DATE);
			classEvent.setInterval(startDate);
			
			
			if (course.getStartTime() != "" && course.getEndTime() != "") {
			    LocalTime startTime = LocalTime.parse(course.getStartTime(), DateTimeFormatter.ofPattern("h:mma"));
				LocalTime endTime = LocalTime.parse(course.getEndTime(), DateTimeFormatter.ofPattern("h:mma"));
				
				classEvent.setInterval(startTime, endTime);
			} else {
				classEvent.setFullDay(true);
				classEvent.setInterval(startDate, endDate);
				
			}
			
			if (course.getWeekdaysList() != null) {
				String[] weekDayList = getWeekDayName(course.getWeekdaysList());
				String weekDayListString = Arrays.toString(weekDayList).replace("[", "").replace("]", "").replace(" ", "");
				classEvent.setRecurrenceRule("RRULE:FREQ=WEEKLY;BYDAY="+ weekDayListString +";UNTIL=" + endDateString + ";");
			}
			conflictCalendar.addEntry(classEvent);
		}

		CalendarSource myCalendarSource = new CalendarSource("My Calendars");
		myCalendarSource.getCalendars().addAll(mainCalendar, conflictCalendar);

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
		createWindow(scene1);
	}
	
	/*
	 * Creates the window for the calendar
	 * 
	 * @param scene1 The scene that the window is 
	 * 				 displayed on
	 */
	public static void createWindow(Scene scene1) {
		Stage newWindow = new Stage();
		newWindow.setTitle("Calendar");
		newWindow.setScene(scene1);
		newWindow.show();
		newWindow.getIcons().add(APP_ICON);

	}
	
}
