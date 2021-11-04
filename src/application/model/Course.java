package application.model;

public class Course {
	private String courseCode;
	private String title;
	private String[] weekdaysList;
	private String location;
	private String faculty;
	private String startTime;
	private String endTime;
	
	public Course(String courseCode, String title, String startTime, String endTime, String[] weekdaysList, String location, String faculty) {
		this.courseCode = courseCode;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekdaysList = weekdaysList;
		this.location = location;
		this.faculty = faculty;
	}
	
	public Course addNewTimeFrame(String secondStartTime, String secondEndTime, String[] secondWeekdaysList) {
		Course secondaryCourse = new Course(courseCode, title, secondStartTime, secondEndTime, secondWeekdaysList, location, faculty);
		return secondaryCourse;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String[] getWeekdaysList() {
		return weekdaysList;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	@Override
	public String toString() {
		String output = location + "\n";
		output += faculty + "\n";
		output += courseCode + "\n";
		output += title + "\n";
		if (weekdaysList != null) {
			for (int i = 0; i < weekdaysList.length; i++) {
				output += weekdaysList[i] + " ";
			}
		}
		if (!startTime.equals("") || !endTime.equals("")) {
			output += "\n" + startTime + " - " + endTime;
		}
		// this is for testing the weekdays case
		return output; 
	}

}
