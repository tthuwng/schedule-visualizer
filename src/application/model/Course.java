package application.model;

public class Course {
	// primary variables
	private String courseCode;
	private String title;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String[] weekdaysList;
	// secondary variables
	private int creditNumber;
	private String location;
	private String roomNumber;
	private String faculty;
	
	public Course(String courseCode, String title, String startDate, String endDate, String startTime, String endTime, String weekdays) {
		this.courseCode = courseCode;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		weekdaysList = weekdays.split(" ");
	}
	
	public void addCourseCredit(String credit) {
		this.creditNumber = Integer.parseInt(credit);
	}
	
	public void addLocation(String location) {
		this.location = location;
	}
	
	public void addFaculty(String name) {
		faculty = name;
	}
	
	public void addNewTimeFrame(String startTime, String endTime, String weekdays) {
		Course secondaryCourse = new Course(courseCode, title, startDate, endDate, startTime, endTime, weekdays);
	}
	
	@Override
	public String toString() {
		// this is for testing the weekdays case
		String emptStr = "";
		for (int i = 0; i < weekdaysList.length; i++) {
			emptStr += weekdaysList[i] + "\n";
		}
		return emptStr;
	}

}
