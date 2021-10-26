package application.controller;

import java.util.ArrayList;

public class TextHandler {
	private String[] inputText;
	private String[][] schedule;
	private ArrayList<String> inputArray = new ArrayList<String>();
	
	public TextHandler(String textArea) {
		inputText = textArea.split("\n");
		for (int i = 0; i < inputText.length; i++) {
			if (!inputText[i].isBlank()) {
				inputArray.add(inputText[i]);
			}
			
		}
		System.out.println(inputArray.toString());
		runHandler();
	}
	
	private void runHandler() {
		int varCount = 0;
		
		for (int i = 0; i < inputText.length; i++) {
			varCount++;
		}
		varCount = varCount - 11;
		int classAMT = varCount/11;
		schedule = new String[classAMT][13];
		
		varCount = 0;
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
