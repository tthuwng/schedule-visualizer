
package application;

import java.util.ArrayList;

public class TextHandler {
	private static final String WEEKDAYS = "M Tu W Th F Sa Su";
	
	private String text;
	

	public TextHandler(String text) {
		this.text = text;
		handlingText();
	}
	private void handlingText() {
		String[] arrText = text.trim().split("\\s\n|\n\n|\n"); //to split some of the special cases seen in the example
		
		for (int i = 0; i < arrText.length; i++) {
			System.out.println(arrText[i]);
		}
		
	}

	
}
