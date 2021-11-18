package application.view;

import java.util.ArrayList;

import application.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Tab2 extends MainView{
	private final ObservableList<String> timeOptions = FXCollections.observableArrayList("AM", "PM");
	
	public Tab2(TabPane tabPane) {
		setTab2(tabPane);
	}
	// Need to update Tab2 to get start date end end date
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
		grid.add(label7, 0, 3);
		startTimeGrid.add(startTime, 0, 0);
		startTimeGrid.add(timeOption1, 1, 0);
		grid.add(startTimeGrid, 1, 3);
		
		GridPane endTimeGrid = new GridPane();
		Label label8 = new Label("End time");
		ComboBox<String> timeOption2 = new ComboBox<String>(timeOptions);
		TextField endTime = new TextField();
		endTime.setMaxWidth(60);
		timeOption2.setMaxWidth(70);
		grid.add(label8, 2, 3);
		endTimeGrid.add(endTime, 0, 0);
		endTimeGrid.add(timeOption2, 1, 0);
		grid.add(endTimeGrid, 3, 3);
		
		Label label9 = new Label("Location");
		TextField location = new TextField();
		grid.add(label9, 0, 4);
		grid.add(location, 1, 4);
		
		Label label10 = new Label("Room No.");
		TextField roomNumber = new TextField();
		grid.add(label10, 0, 5);
		grid.add(roomNumber, 1, 5);
		
		Label label11 = new Label("Faculty");
		TextField facultyName = new TextField();
		grid.add(label11, 0, 6);
		grid.add(facultyName, 1, 6);
	
		//Add Prompt Texts into text field boxes
		courseCode.setPromptText("REGL-100");
		courseTitle.setPromptText("Intro to Ethics");
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
		System.out.print("This is a message");
		
		ArrayList<Course> courses = new ArrayList<Course>();
		addCourseButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (!startTime.getText().equals("") && !endTime.getText().equals("")) {
					ArrayList<String> classDaysArray = new ArrayList<String>();
					String classDays = "";
					if (sun.isSelected() == true){
						classDays+= "S ";	
						classDaysArray.add("S ");
					}
					if (mon.isSelected() == true){
						classDays+= "M ";
						classDaysArray.add("M ");
					}
					if (tue.isSelected() == true){
						classDays+= "Tu ";
						classDaysArray.add("Tu ");
					}
					if (wed.isSelected() == true){
						classDays+= "W ";
						classDaysArray.add("W ");
					}
					if (thu.isSelected() == true){
						classDays+= "Th ";
						classDaysArray.add("Th ");
					}
					if (fri.isSelected() == true){
						classDays+= "F ";
						classDaysArray.add("F ");
					}
					if (sat.isSelected() == true){
						classDays+= "Sat ";
						classDaysArray.add("Sat ");
					}
					
					int lengthAList = classDaysArray.size();
					String[] classDaysList = new String[lengthAList];
					String fullLocation = location.getText() + " " +roomNumber.getText();
					
					for (int i = 0; i < lengthAList; i++) {
						classDaysList[i] = classDaysArray.get(i);
					}
					
					
					String timeOp1 = startTime.getText() + timeOption1.getValue().toString();
					String timeOp2 = endTime.getText() +  timeOption2.getValue().toString();
					
					Course courseCustom = new Course(courseCode.getText(), courseTitle.getText(), "", "", "", timeOp1, timeOp2,  // need to change empty string
							classDaysList, fullLocation,  facultyName.getText());
					courses.add(courseCustom);
					System.out.println(courseCustom.toString());
					
					
	/*				String[] customSchedule = new String[11];
					customSchedule[0] = courseCode.getText();
					customSchedule[1] = courseTitle.getText();
					customSchedule[5] = classDays;
					customSchedule[6] = timeOp1; 
					customSchedule[7] = timeOp2; 
					customSchedule[8] = location.getText();
					customSchedule[9] = roomNumber.getText();
					customSchedule[10] = facultyName.getText();
				*/	
					// this for Course Class testing
					//Course newCourse = new Course(customSchedule[0], customSchedule[1], customSchedule[3], customSchedule[4], customSchedule[6], customSchedule[7], classDays);
					//System.out.println(newCourse.toString());
					//Debugging and making sure I actually get what I was fucking looking for comment this out or remove it if you dont need it anymore (look in console window)
		//			for (int i = 0; i < 11; i++) {
		//				System.out.println(customSchedule[i]);
		//			}
					
					//Resetting the textfields to beblank
					courseCode.clear();
					courseTitle.clear();
					classDays = null;
					classDaysArray = null;
					fullLocation = null;
					classDaysList = null;
					
					
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
			}
				
});
	}
}
