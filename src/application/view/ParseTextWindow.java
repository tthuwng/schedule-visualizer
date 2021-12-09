package application.view;

import java.util.ArrayList;

import application.controller.TextHandler;
import application.model.Course;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ParseTextWindow extends MainView {
	public ParseTextWindow(TabPane tabPane) {
		setTab1(tabPane);
	}

	/**
	 * setTab1 is to create the Tab of the Parse Text User can use this class to
	 * parse their schedule that they copy from their Arches.
	 * 
	 * @param tabPane
	 */
	private void setTab1(TabPane tabPane) {
		Tab tab1 = new Tab("Parse Text");
		tab1.setClosable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(5);
		tab1.getStyleClass().add("parse-text-tab");

		// Text Area
		Text instruction = new Text("Parse your schedule here, we will get your courses schedule for you");
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(1080);
		textArea.setPrefWidth(1920);
		grid.add(instruction, 0, 0);
		grid.add(textArea, 0, 1);

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
		
		//Text output notification
		Text notification = new Text("No Course added");
		subGrid.add(notification, 3, 0);
		GridPane.setHalignment(notification, HPos.RIGHT);
		grid.add(subGrid, 0, 2);
		
		addCourseButton.setOnAction(action -> {
			String update = parseTextSchedulize(textArea);
			notification.setText(update);
		});
		
		submitButtonCreate.setOnAction(action -> {
			activateSchedule();
		});
		
		removeCourseButton.setOnAction(action -> {
			removeCourses();
			notification.setText("No Course added");
			textArea.clear();
		});
		
		tab1.setContent(grid);
		tabPane.getTabs().add(tab1);
	}
	
	private String parseTextSchedulize(TextArea textArea) {
		if (!textArea.getText().equals("")) {
			TextHandler parseText = new TextHandler(textArea.getText());
			courses.addAll(parseText.getCourseArray());
			if (courses.isEmpty()) {
				String cannotReg = "Cannot recognize course.";
				System.out.println(cannotReg);
				return cannotReg;
			} else {
				String addedCourse = "empty";
				int courseNum = courses.size();
				if (courseNum == 1) {
					addedCourse = "A course added";
				} else {
					addedCourse = courseNum + " courses added";
				}
				return addedCourse;
			}
		} else {
			String nothingEntered = "You entered nothing :<";
			System.out.println(nothingEntered);
			return nothingEntered;
		}

	}
}
