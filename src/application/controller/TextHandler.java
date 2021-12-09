package application.controller;

import java.util.ArrayList;

import application.model.Course;

public class TextHandler{
	//List data fields
	private ArrayList<Course> courseArray = new ArrayList<Course>();
	private ArrayList<String> inputArray = new ArrayList<String>();
	//data fields
	private String courseCode = "";
	private String title = "";
	private String credit = "";
	private String startDate = "";
	private String endDate = "";
	private String[] weekdaysList;
	private String location = "";
	private String faculty = "";
	private String startTime = "";
	private String endTime = "";
	
	/*
	 * Text handler that deals with the parsing of the input
	 * 
	 * @param textArea The text area where the user entered their
	 * 				   schedule
	 */
	public TextHandler(String textArea) {
		//splits each String value for each new line
		String[] inputText = textArea.split("\n");
		for (int i = 0; i < inputText.length; i++) {
			if (!inputText[i].isBlank()) {
				inputArray.add(inputText[i]);
			}
			
		}
		runHandler();
	}
	/*
	 * An arrayList of the courses the user entered
	 * 
	 * return courseArray The array of all of the inputted
	 * 		  courses
	 */
	public ArrayList<Course> getCourseArray() {
		return courseArray;
	}
	/*
	 * Adds the course to the courseArray
	 */
	private void addCourse() {
		courseArray.add(new Course(courseCode, title, credit, startDate, endDate, startTime, endTime, weekdaysList, location, faculty));
	}
	/*
	 * Resets the data fields to null
	 */
	private void resetData() {
		courseCode = "";
		title = "";
		weekdaysList = null;
		location = "";
		faculty = "";
		startTime = "";
		endTime = "";
	}
	/*
	 * Helper method that parses the courses and handles
	 * the special cases
	 */
	private void runHandler() {
		int i = 0;
		int max = inputArray.size();
		while (i < max) {
			// initialize the variable after each course
			resetData();
			
			String data = inputArray.get(i);
			if (data.contains("-") && !(data.contains("AM") || data.contains("PM"))) {
				// some mandatory data 
				courseCode = data; // course code
				title = inputArray.get(i+1); // course name
				
				credit = inputArray.get(i+2); // credit 
				startDate = inputArray.get(i+3); // start date
				endDate = inputArray.get(i+4); // end date
				
				if (inputArray.get(i+5).contains(",")) {
					faculty = inputArray.get(i+5);
					addCourse();
					i += 6;
				} 
				else if (inputArray.get(i+5).contains(" ")) {
					weekdaysList = inputArray.get(i+5).split("\\s"); // the weekdays
					
					if (inputArray.get(i+7).contains(",")) {
						location = inputArray.get(i+5) + " " + inputArray.get(i+6);
						faculty = inputArray.get(i+7);
						i += 8;
						addCourse();
						
					} else {
						String[] times = inputArray.get(i+6).split(" - "); // start and end time
						startTime = times[0];
						endTime = times[1];
						// check if the course has second time frame (due to the case of Viet Physics Class)
						if ((i+11 < max) && inputArray.get(i+11).contains(",")) {
							String[] secondWeekdaysList = inputArray.get(i+7).split("\\s");
							String[] secondTimes = inputArray.get(i+8).split(" - ");
							String secondStartTime = secondTimes[0];
							String secondEndTime = secondTimes[1];
							location = inputArray.get(i+9) + " " + inputArray.get(i+10);
							faculty = inputArray.get(i+11);
							Course createACourse = new Course(courseCode, title, credit, startDate, endDate, startTime, endTime, weekdaysList, location, faculty);
							courseArray.add(createACourse);
							courseArray.add(createACourse.addNewTimeFrame(secondStartTime, secondEndTime, secondWeekdaysList));
							i += 12;
							
						} else {
							// for normal course
							location = inputArray.get(i+7) + " " + inputArray.get(i+8);
							faculty = inputArray.get(i+9);
							addCourse();
							i += 10;
						}
					}
				} else {
					location = inputArray.get(i+5) + " " + inputArray.get(i+6);
					faculty = inputArray.get(i+7);
					i += 8;
					addCourse();
					
				}
			} else {
				i++;
			}
		}
	}
	
}
