
package application;

import java.util.ArrayList;

public class TextHandler {
	private static final String WEEKDAYS = "M Tu W Th F Sa Su";
	
	private String text;/*
	// basic name and info of course
	private String term;
	private String status;
	private String courseCode;
	private String title;
	// meeting information
	private String startDate;
	private String endDate;
	ArrayList weekdaysList = new ArrayList();
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
*/
	public TextHandler(String text) {
		this.text = text;
		handlingText();
	}
	private void handlingText() {
		String[] arrText = text.trim().split("\n\n|\n|\\s\n");
		for (int i = 0; i < arrText.length; i++) {
			System.out.println(arrText[i]);
		}
		// Split the extra \n in each line is there is two downline then split or 1 down
		// line -> split
		/*
		int i = 0;
		while (i < arrText.length) {
			this.term = arrText[i];
			this.status = arrText[i + 1];
			splitCourseCodeAndName(arrText[i + 2]);
			// This section to split the meeting information line
			splitMeetingInfo(arrText[i + 3]);
			// System.out.print(startDate + " " + endDate + "\n");
			
			i += 8;
		}*/
	}
/*
	private void splitCourseCodeAndName(String arrText) {
		String[] courseCodeAndName = arrText.split(" ", 2); // split the course line into the course code and title by
															// the first "space"
		this.courseCode = courseCodeAndName[0];
		this.title = courseCodeAndName[1];
	}
	
	private void splitMeetingInfo(String arrText) {
		String[] meetingInfo = arrText.split(" ", 2);
		String[] dates = meetingInfo[0].split("-");
		String[] startArr = dates[0].split("/");
		this.startDate = String.join("", startArr); // to join the date to a string
		String[] endArr = dates[1].split("/");
		this.endDate = String.join("", endArr); // to join the date to a string
		if (meetingInfo.length > 1) {
			if (!meetingInfo[1].substring(0, 1).equals("D")) {
				String[] timeAndLocationList = meetingInfo[1].split(", |\\s");
				for (int i = 0; i < timeAndLocationList.length; i++) {
					if (WEEKDAYS.contains(timeAndLocationList[i])) {
						weekdaysList.add(timeAndLocationList[i]);
						System.out.println(timeAndLocationList[i]);
					}
					
				}
			}
		}
	}*/
	
}
