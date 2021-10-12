package application.controller;

public class TextHandler {
	private String[] inputText;
	private String[][] schedule;
	
	public TextHandler(String textArea) {
		inputText = textArea.split("\n");
		runHandler();
	}
	/*
	 * schedule values
	 * schedule [class][0] = Course 
	 * schedule [class][1] = Title
	 * schedule [class][2] = Credit
	 * schedule [class][3] = Start Date
	 * schedule [class][4] = End Date
	 * schedule [class][5] = Weekdays1 (Sometimes Empty)
	 * schedule [class][6] = Time1 (Sometimes Empty)
	 * schedule [class][7] = Weekdays2 (Sometimes Empty)
	 * schedule [class][8] = Time2 (Sometimes Empty)
	 * schedule [class][9] = Building
	 * schedule [class][10] = Class Room
	 * schedule [class][11] = Instructor
	 */
	private void runHandler() {
		int varCount = 0;
		
		
		for (int i = 12; i < inputText.length; i++) {
			varCount++;
		}
		
		int classAMT = varCount/11;
		schedule = new String[classAMT][13];
		
		varCount = 12;
		for(int c = 0; c<classAMT; c++)
		{
			for (int i = 0; i < 12; i++) {
				if(inputText[varCount].contains(","))
				{
					i = 11;
				}
				schedule[c][i] = inputText[varCount];
				varCount++;
					
			}
		}
	}
	public String[][] getSchedule() {
		return schedule;
	}
	
}
