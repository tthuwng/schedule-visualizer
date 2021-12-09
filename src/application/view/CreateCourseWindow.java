package application.view;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CreateCourseWindow extends MainView {
	private final ObservableList<String> timeOptions = FXCollections.observableArrayList("AM", "PM");

	public CreateCourseWindow(TabPane tabPane) {
		setTab2(tabPane);
	}

	// Need to update Tab2 to get start date end end datesdf
	/**
	 * setTab2 allows user to manually plug in their schedules class by class
	 * 
	 * @param tabPane The TabPane object that the window 
	 * 				  Displays (GUI)
	 * 				  
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

		grid.add(label6, 0, 2);
		weekGrid.add(sun, 0, 0);
		weekGrid.add(mon, 1, 0);
		weekGrid.add(tue, 2, 0);
		weekGrid.add(wed, 3, 0);
		weekGrid.add(thu, 4, 0);
		weekGrid.add(fri, 5, 0);
		weekGrid.add(sat, 6, 0);

		grid.add(weekGrid, 1, 2, 3, 1);

		GridPane startTimeGrid = new GridPane();
		Label label7 = new Label("Start time");
		TextField startTime = new TextField();
		ComboBox<String> timeOption1 = new ComboBox<String>(timeOptions);
		startTime.setMaxWidth(60);
		timeOption1.setMaxWidth(70);
		grid.add(label7, 0, 4);
		startTimeGrid.add(startTime, 0, 0);
		startTimeGrid.add(timeOption1, 1, 0);
		grid.add(startTimeGrid, 1, 4);

		GridPane endTimeGrid = new GridPane();
		Label label8 = new Label("End time");
		ComboBox<String> timeOption2 = new ComboBox<String>(timeOptions);
		TextField endTime = new TextField();
		endTime.setMaxWidth(60);
		timeOption2.setMaxWidth(70);
		grid.add(label8, 2, 4);
		endTimeGrid.add(endTime, 0, 0);
		endTimeGrid.add(timeOption2, 1, 0);
		grid.add(endTimeGrid, 3, 4);

		Label label8half = new Label("Credit");
		TextField credit = new TextField();
		grid.add(label8half, 0, 5);
		grid.add(credit, 1, 5);
		
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

		// Add Prompt Texts into text field boxes
		courseCode.setPromptText("REGL-100");
		courseTitle.setPromptText("Intro to Ethics");
		startTime.setPromptText("9:00");
		endTime.setPromptText("10:00");
		credit.setPromptText("4");
		location.setPromptText("Old Main");
		roomNumber.setPromptText("209");
		facultyName.setPromptText("Dr. Abbe");

		GridPane subGrid = new GridPane();
		subGrid.setPadding(new Insets(0));
		subGrid.setHgap(5);
		subGrid.setVgap(5);

		// Submit Button
		Button addCourseButton = new Button("Add Courses");
		addCourseButton.getStyleClass().add("add-course-button");
		subGrid.add(addCourseButton, 0, 0);

		// Schedulize Button
		Button submitButtonCreate = new Button("Schedulize");
		submitButtonCreate.getStyleClass().add("submit-button");
		subGrid.add(submitButtonCreate, 1, 0);

		// Remove Course Button
		Button removeCourseButton = new Button("X");
		removeCourseButton.getStyleClass().add("remove-course-button");
		subGrid.add(removeCourseButton, 2, 0);

		// Text output notification
		Text notification = new Text("No Course added");
		subGrid.add(notification, 3, 0);
		GridPane.setHalignment(notification, HPos.RIGHT);
		grid.add(subGrid, 0, 2);

		primaryGrid.add(instruction2, 0, 0);
		primaryGrid.add(grid, 0, 1);

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.BOTTOM_LEFT);
		hBox.getChildren().add(subGrid);

		primaryGrid.add(hBox, 0, 2);

		tab2.setContent(primaryGrid);
		tabPane.getTabs().add(tab2);

		ArrayList<Course> courses = new ArrayList<Course>();
		addCourseButton.setOnAction(new EventHandler<ActionEvent>() {
<<<<<<< Updated upstream
			/*
			 * Formats the date in the course object
			 * 
			 * @param date The date in the course object
			 * 			   to be reformatted
			 * 
			 * return String this returns the formatted date
			 */
			private String formatDate(DatePicker date) {
				String[] splitedDate = date.getValue().toString().split("-");
				String formatedDate = splitedDate[1] + "/" + splitedDate[2] + "/" + splitedDate[0].substring(2);
				return formatedDate;
			}
			/*
			 * Validates the start and end date in the course object
			 * 
			 * @param start The start date of the course
			 * @param end   The end date of the course
			 * 
			 * return boolean returns if the start and end dates
			 *  			  are valid
			 */
			private boolean validateStartEndDate(String start, String end) {
				int startYear = Integer.parseInt(start.substring(6));
				int endYear = Integer.parseInt(end.substring(6));
				int startMonth = Integer.parseInt(start.substring(0, 2));
				int endMonth = Integer.parseInt(end.substring(0, 2));
				int startDay = Integer.parseInt(start.substring(3, 5));
				int endDay = Integer.parseInt(end.substring(3, 5));
				if (endYear < startYear) {
					return false;
				} else {
					if (endMonth < startMonth) {
						return false;
					} else {
						if (endDay < startDay) {
							return false;
						} else {
							return true;
						}
					}
				}
			}
		/*
		 * Collects inputted user data and creates a course object
		 * 
		 * @param event The event of the submit button 
		 *              being clicked
		 */
=======
			
>>>>>>> Stashed changes
			@Override
			public void handle(ActionEvent event) {
				String startDateText = formatDate(startDate);
				String endDateText = formatDate(endDate);
				if (validateStartEndDate(startDateText, endDateText)) {
					if (!startTime.getText().equals("") && !endTime.getText().equals("")) {
						ArrayList<String> classDaysArray = new ArrayList<String>();
						if (sun.isSelected() == true) {
							classDaysArray.add("S ");
						}
						if (mon.isSelected() == true) {
							classDaysArray.add("M ");
						}
						if (tue.isSelected() == true) {
							classDaysArray.add("Tu ");
						}
						if (wed.isSelected() == true) {
							classDaysArray.add("W ");
						}
						if (thu.isSelected() == true) {
							classDaysArray.add("Th ");
						}
						if (fri.isSelected() == true) {
							classDaysArray.add("F ");
						}
						if (sat.isSelected() == true) {
							classDaysArray.add("Sat ");
						}
	
						int lengthAList = classDaysArray.size();
						String[] classDaysList = new String[lengthAList];
						String fullLocation = location.getText() + " " + roomNumber.getText();
	
						for (int i = 0; i < lengthAList; i++) {
							classDaysList[i] = classDaysArray.get(i);
						}
	
						String timeOp1 = startTime.getText() + timeOption1.getValue().toString();
						String timeOp2 = endTime.getText() + timeOption2.getValue().toString();
	
						Course courseCustom = new Course(courseCode.getText(), courseTitle.getText(), "", "", "", timeOp1,
								timeOp2, // need to change empty string
								classDaysList, fullLocation, facultyName.getText());
						courses.add(courseCustom);
						System.out.println(courseCustom.toString());
	
						clearCreateWindow();
	
					}
				} else {
					notification.setText("Your Date is invalid");
				}
			}
			/*
			 * Clears the user inputted fields
			 */
			private void clearCreateWindow() {
				courseCode.clear();
				courseTitle.clear();

				sun.setSelected(false);
				mon.setSelected(false);
				tue.setSelected(false);
				wed.setSelected(false);
				thu.setSelected(false);
				fri.setSelected(false);
				sat.setSelected(false);

				timeOption1.setValue(null);
				timeOption2.setValue(null);
				startTime.clear();
				endTime.clear();
				location.clear();
				roomNumber.clear();
				facultyName.clear();
			}
		});
		
		
	}
	private String formatDate(DatePicker date) {
		String[] splitedDate = date.getValue().toString().split("-");
		String formatedDate = splitedDate[1] + "/" + splitedDate[2] + "/" + splitedDate[0].substring(2);
		return formatedDate;
	}
	
	private boolean validateStartEndDate(String start, String end) {
		int startYear = Integer.parseInt(start.substring(6));
		int endYear = Integer.parseInt(end.substring(6));
		int startMonth = Integer.parseInt(start.substring(0, 2));
		int endMonth = Integer.parseInt(end.substring(0, 2));
		int startDay = Integer.parseInt(start.substring(3, 5));
		int endDay = Integer.parseInt(end.substring(3, 5));
		if (endYear < startYear) {
			return false;
		} else if (endYear == startYear) {
			if (endMonth < startMonth) {
				return false;
			} else if (endMonth == startMonth){
				if (endDay < startDay) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
}
