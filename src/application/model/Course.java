package application.model;

public class Course {
	private String courseCode;
	private String title;
	private String credit;
	private String startDate;
	private String endDate;
	private String[] weekdaysList;
	private String location;
	private String faculty;
	private String startTime;
	private String endTime;
	public int girth;
	
	
	public Course(String courseCode, String title, String credit, String startDate, String endDate, String startTime, String endTime, String[] weekdaysList, String location, String faculty) {
		this.courseCode = courseCode;
		this.title = title;
		this.credit = credit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekdaysList = weekdaysList;
		this.location = location;
		this.faculty = faculty;
		
	}
	
	public Course addNewTimeFrame(String secondStartTime, String secondEndTime, String[] secondWeekdaysList) {
		Course secondaryCourse = new Course(courseCode, title, credit, startDate, endDate, secondStartTime, secondEndTime, secondWeekdaysList, location, faculty);
		return secondaryCourse;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getTitle() {
		return title;
	}
	public String getCredit() {
		return credit;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
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
	
	public int getGirth() {
		return girth;
	}
	
	@Override
	public String toString() {
		String output = "Location: "  +location + "\n";
		output += "Faculty: " + faculty + "\n";
		output += "Course Code: " + courseCode + "\n";
		output += "Title: " + title + "\n";
		output += "Weekdays: ";
		if (weekdaysList != null) {
			for (int i = 0; i < weekdaysList.length; i++) {
				output += weekdaysList[i] + " ";
			}
		}
		output += "\nTime: ";
		if (!startTime.equals("") || !endTime.equals("")) {
			output += startTime + " - " + endTime;
		}
		output += "\nDate: ";
		if (!startDate.equals("") || !endDate.equals("")) {
			output += startDate + " - " + endDate;
		}
		output += "\n\n";
		// this is for testing the weekdays case
		return output;
	}

}
