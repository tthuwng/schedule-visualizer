package application.controller;

public class TextHandler {
	private String[] inputText;
	private String[][] schedule;
	
	public TextHandler(String textArea) {
		inputText = textArea.split("\n");
		runHandler();
	}
	
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
