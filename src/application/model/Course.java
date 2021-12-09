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
	/*
	 * 
	 */
	public Course addNewTimeFrame(String secondStartTime, String secondEndTime, String[] secondWeekdaysList) {
		Course secondaryCourse = new Course(courseCode, title, credit, startDate, endDate, secondStartTime, secondEndTime, secondWeekdaysList, location, faculty);
		return secondaryCourse;
	}
	/*
	 * Returns the course code of the course object
	 * 
	 * return String of the course code
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/*
	 * Returns the title of the course
	 * 
	 * return String Course Title
	 */
	public String getTitle() {
		return title;
	}
	/*
	 * Returns the number of credits a course is worth
	 * 
	 * return String the number of credits
	 */
	public String getCredit() {
		return credit;
	}
	/*
	 * Returns the start date of the course
	 * 
	 * return String The start date of the course
	 */
	public String getStartDate() {
		return startDate;
	}
	/*
	 * Returns the end date of the course
	 * 
	 * return String The end date of the course
	 */
	public String getEndDate() {
		return endDate;
	}
	/*
	 * Returns the days of the week the course occurs on
	 * 
	 * return String[] An array of the weekDays
	 */
	public String[] getWeekdaysList() {
		return weekdaysList;
	}
	/*
	 * Returns the start time of the course
	 * 
	 * return String The start time of the course
	 */
	public String getStartTime() {
		return startTime;
	}
	/*
	 * Returns the end time of the course
	 * 
	 * return String The end time of the course
	 */
	public String getEndTime() {
		return endTime;
	}
	/*
	 * Returns the location of the course
	 * 
	 * return String The location of the course
	 */
	public String getLocation() {
		return location;
	}
	/*
	 * Returns the faculty teaching the course
	 * 
	 * return String The teacher of the course
	 */
	public String getFaculty() {
		return faculty;
	}
	/*
	 *  This method doesn't do anything, it's an easter egg
	 */
	public int getGirth() {
		return girth;
	}
	/*
	 * ToString method of the course
	 * 
	 * returns String The course represented as a String
	 */
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
