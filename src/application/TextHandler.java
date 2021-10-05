package application;

public class TextHandler {
	private String text;
	// basic name and info of course
	private String term;
	private String status;
	private String courseCode;
	private String title;
	//meeting information
	private String startDate;
	private String endDate;
	private String[] weekdaysList;
	private int startTime;
	private int endTime;
	private String location;
	private int roomNum;
	
	
	private String facultyName;
	private int numCapacity;
	private int numSeatsLeft;
	private int numWaitlist;
	
	private int numCredits;
	private String academicLevel;
	
	public TextHandler(String text) {
		this.text = text;
		handlingText();
	}
	private void handlingText() {
		String[] arrText = text.trim().split("\n\n|\n"); 
		//Split the extra \n in each line is there is two downline then split or 1 down line -> split
		int i = 0;
		while (i < arrText.length) {
			this.term = arrText[i];
			this.status = arrText[i+1];
			String[] courseCodeAndName = arrText[i+2].split(" ", 2); // split the course line into the course code and title by the first "space"
			this.courseCode = courseCodeAndName[0];
			this.title =  courseCodeAndName[1];
			i += 8;
		}
	}
}
