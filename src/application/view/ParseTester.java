package application.view;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import application.controller.TextHandler;
import application.model.Course;


import org.junit.jupiter.api.Test;



class ParseTester {

	@Test
	void test() throws FileNotFoundException {
		String everything1 = "";
		String everything2 = "";
		File input = new File("/Users/maxsellers/eclipse-workspace-2021/schedule-visualizer/src/application/resources/ScheduleExample.txt");
		Scanner sc = new Scanner(input);
		while(sc.hasNextLine())
		{
			everything1 += sc.nextLine() + "\n";
		}
		System.out.println(everything1);
		File output = new File("/Users/maxsellers/eclipse-workspace-2021/schedule-visualizer/src/application/resources/Output.txt");
		Scanner sc2 = new Scanner(output);
		while(sc2.hasNextLine())
		{
			everything2 += sc2.nextLine() + "\n";
		}
		System.out.println(everything2);
		
		TabPane tabpane = new TabPane();
		Tab1 tab = new Tab1(tabpane);
		TextArea txt = new TextArea();
		txt.setText(everything1);
		System.out.println(everything1);
		System.out.println(everything2);
		System.out.println(tab.parseTextSchedulizeTest(txt));
		assertEquals(tab.parseTextSchedulizeTest(txt), everything2);
	}
	
//	@Test
//	public String parseTextSchedulizeTest(TextArea textArea) {
//		String output = "";
//		if (!textArea.getText().equals("")) {
//			TextHandler parseText = new TextHandler(textArea.getText());
//			ArrayList<Course> courses = parseText.getCourseArray();
//			if (!courses.isEmpty()) {
//				CalendarView run = new CalendarView();
//				for (Course i : courses) {
//					output += (i.toString() + "\n");
//				}
//			} else {
//				output += "Cannot recognize course.";
//			}
//		} else {
//			output += "You entered nothing :< hung owes me $10 for portillos";
//			
//		}
//		return output;
//		
//	}

}
