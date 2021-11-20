package application.view;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import org.junit.Test;

import application.controller.TextHandler;

public class CalendarTester {

	@Test
	public void test() throws FileNotFoundException {
		
		String everything1 = "";
		String everything2 = "";
		File input = new File("/Users/maxsellers/eclipse-workspace-2021/schedule-visualizer/src/application/resources/Schedule Examples.txt");
		Scanner sc = new Scanner(input);
		while(sc.hasNextLine())
		{
			everything1 += sc.nextLine() + "\n";
		}
		File output = new File("/Users/maxsellers/eclipse-workspace-2021/schedule-visualizer/src/application/resources/Output.txt");
		Scanner sc2 = new Scanner(output);
		while(sc2.hasNextLine())
		{
			everything2 += sc2.nextLine() + "\n";
		}
		
		TextHandler handler = new TextHandler(everything1);
		System.out.println(handler.getCourseArray().toString());
		assertEquals(handler.getCourseArray().toString()+"\n", everything2);
	}

}
