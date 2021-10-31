package application.controller;

import java.util.ArrayList;

import application.model.Course;

public class TextHandler {
	//private String[][] schedule;
	private ArrayList<Course> courseArray = new ArrayList<Course>();
	private ArrayList<String> inputArray = new ArrayList<String>();
	
	public TextHandler(String textArea) {
		String[] inputText = textArea.split("\n");
		for (int i = 0; i < inputText.length; i++) {
			if (!inputText[i].isBlank()) {
				inputArray.add(inputText[i]);
			}
			
		}
		System.out.println(inputArray.toString());
		runHandler();
	}
	
	public ArrayList<Course> getCourseArray() {
		return courseArray;
	}
	
	private void runHandler() {
		int i = 0;
		int max = inputArray.size();
		while (i < max) {
			// initialize the variable after each course
			String courseCode = "";
			String title = "";
			String[] weekdaysList;
			String location = "";
			String faculty = "";
			String startTime = "";
			String endTime = "";
			
			String data = inputArray.get(i);
			if (data.contains("-") && !(data.contains("AM") || data.contains("PM"))) {
				// some mandatory data 
				courseCode = data; // course code
				title = inputArray.get(i+1); // course name
				weekdaysList = inputArray.get(i+5).split("\\s"); // the weekdays
				System.out.println(inputArray.get(i+7) + "||" + inputArray.get(i+7).contains(","));
				System.out.println(courseCode +
						title +
						location + 
						faculty
						);
				if (inputArray.get(i+7).contains(",")) {
					location = inputArray.get(i+5) + inputArray.get(i+6);
					faculty = inputArray.get(i+7);
					System.out.println(faculty + location);
					i += 8;
					System.out.println(inputArray.get(i));
					Course createACourse = new Course(courseCode, title, startTime, endTime, weekdaysList, location, faculty);
					courseArray.add(createACourse);
				} else {
					String[] times = inputArray.get(i+6).split(" - "); // start and end time
					startTime = times[0];
					endTime = times[1];
					System.out.println(startTime +endTime);
					// check if the course has second time frame (due to the case of Viet Physics Class)
					if ((i+11 < max) && inputArray.get(i+11).contains(",")) {
						String[] secondWeekdaysList = inputArray.get(i+7).split("\\s");
						String[] secondTimes = inputArray.get(i+8).split(" - ");
						String secondStartTime = secondTimes[0];
						String secondEndTime = secondTimes[1];
						location = inputArray.get(i+9) + inputArray.get(i+10);
						faculty = inputArray.get(i+11);
						Course createACourse = new Course(courseCode, title, startTime, endTime, weekdaysList, location, faculty);
						courseArray.add(createACourse);
						courseArray.add(createACourse.addNewTimeFrame(secondStartTime, secondEndTime, secondWeekdaysList));
						i += 12;
						
					} else {
						// for normal course
						location = inputArray.get(i+7) + inputArray.get(i+8);
						faculty = inputArray.get(i+9);
						System.out.println(location +faculty);
						Course createACourse = new Course(courseCode, title, startTime, endTime, weekdaysList, location, faculty);
						courseArray.add(createACourse);
						i += 10;
					}
				}
				
			}
			System.out.println(courseCode +
					title +
					location + 
					faculty
					);
		}
	}
	
}
