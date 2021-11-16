package application.view;

import java.util.ArrayList;

import application.controller.TextHandler;
import application.model.Course;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Tab1 extends MainView {
	public Tab1(TabPane tabPane) {
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

		// Submit Button
		Button submitButton = new Button("Schedulize");
		submitButton.getStyleClass().add("submit-button");
		grid.add(submitButton, 0, 2);

		submitButton.setOnAction(action -> {
			parseTextSchedulize(textArea);
		});

		tab1.setContent(grid);
		tabPane.getTabs().add(tab1);
	}

	private void parseTextSchedulize(TextArea textArea) {

		if (!textArea.getText().equals("")) {
			TextHandler parseText = new TextHandler(textArea.getText());
			ArrayList<Course> courses = parseText.getCourseArray();
			if (!courses.isEmpty()) {
				CalendarView run = new CalendarView();
				for (Course i : courses) {
					System.out.println(i.toString() + "\n");
				}
			} else {
				System.out.println("Cannot recognize course.");
			}
		} else {
			System.out.println("You entered nothing :< hung owes me $10 for portillos");

		}

	}
}
