package application.view;

import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import application.controller.TextHandler;
import application.model.Course;

public class ParseTester {

	@Test
	public void test() throws IOException {

		String file = "SCHEDULE 1\n" + "\n" + "CSC-305-01\n" + "Software Development\n" + "4.00000\n" + "08/30/21\n"
				+ "12/10/21\n" + "Tu Th \n" + "8:30AM - 10:10AM\n" + " 	 	\n" + "OLIN\n" + "209\n"
				+ "Khan Mohd, Tauheed\n" + "MATH-410-01\n" + "Real Analysis\n" + "4.00000\n" + "08/30/21\n"
				+ "12/10/21\n" + "M W F \n" + "10:30AM - 11:45AM\n" + " 	 	\n" + "OLIN\n" + "202\n"
				+ "Clauss, Jon M\n" + "MUEN-309-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/30/21\n" + "12/10/21\n"
				+ "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MUEN-309-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/30/21\n"
				+ "12/10/21\n" + "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MUEN-309-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/30/21\n"
				+ "12/10/21\n" + "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MULS-300-PN-RE\n" + "Piano\n" + "2.00000\n" + "08/30/21\n" + "12/10/21\n"
				+ " 	 	 	 	 	 	\n" + "Elfline, Robert P\n" + "MUSC-311-01\n" + "Mus Styles & Lit I\n"
				+ "4.00000\n" + "08/30/21\n" + "12/10/21\n" + "Tu Th \n" + "12:20PM - 2:00PM\n" + " 	 	\n"
				+ "BERG\n" + "LARSON\n" + "Ehrlich, Janina A\n" + "MUSC-360-03\n" + "Conducting I\n" + "4.00000\n"
				+ "08/30/21\n" + "12/10/21\n" + "M W F \n" + "1:30PM - 2:45PM\n" + " 	 	\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M";

		String output = "[Location: OLIN 209\n" + "Faculty: Khan Mohd, Tauheed\n" + "Course Code: CSC-305-01\n"
				+ "Title: Software Development\n" + "Weekdays: Tu Th \n" + "Time: 8:30AM - 10:10AM\n"
				+ "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: OLIN 202\n" + "Faculty: Clauss, Jon M\n"
				+ "Course Code: MATH-410-01\n" + "Title: Real Analysis\n" + "Weekdays: M W F \n"
				+ "Time: 10:30AM - 11:45AM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-309-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-309-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n"
				+ "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-309-NC\n" + "Title: Symphonic Band\n" + "Weekdays: M W F \n"
				+ "Time: 4:30PM - 5:30PM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-309-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-309-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n"
				+ "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-309-NC\n" + "Title: Symphonic Band\n" + "Weekdays: Tu Th \n"
				+ "Time: 4:15PM - 5:30PM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: \n"
				+ "Faculty: Elfline, Robert P\n" + "Course Code: MULS-300-PN-RE\n" + "Title: Piano\n" + "Weekdays: \n"
				+ "Time: \n" + "Date: 08/30/21 - 12/10/21\n" + "\n" + ", Location: BERG LARSON\n"
				+ "Faculty: Ehrlich, Janina A\n" + "Course Code: MUSC-311-01\n" + "Title: Mus Styles & Lit I\n"
				+ "Weekdays: Tu Th \n" + "Time: 12:20PM - 2:00PM\n" + "Date: 08/30/21 - 12/10/21\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUSC-360-03\n"
				+ "Title: Conducting I\n" + "Weekdays: M W F \n" + "Time: 1:30PM - 2:45PM\n"
				+ "Date: 08/30/21 - 12/10/21\n" + "\n" + "]";

		TextHandler handler = new TextHandler(file);
		System.out.println(handler.getCourseArray().toString());
		assertEquals(handler.getCourseArray().toString(), output);
	}

	@Test
	public void test2() throws IOException {
		String file2 = "SCHEDULE 2\n" + "\n" + "CSC-202-01\n" + "Data Structures\n" + "4.00000\n" + "02/10/21\n"
				+ "05/21/21\n" + "M W F \n" + "12:00PM - 1:15PM\n" + " 	 	\n" + "OLIN\n" + "208\n"
				+ "Mueller, Diane C\n" + "CSC-202L-01\n" + "Lab component of CSC-202\n" + "0.00000\n" + "02/10/21\n"
				+ "05/21/21\n" + "Tu \n" + "12:15PM - 2:05PM\n" + " 	 	\n" + "OLIN\n" + "307\n"
				+ "Mueller, Diane C\n" + "MATH-450-01\n" + "Algebraic Structures\n" + "4.00000\n" + "02/10/21\n"
				+ "05/21/21\n" + "M W F \n" + "1:30PM - 2:45PM\n" + " 	 	\n" + "OLIN\n" + "201\n" + "Clauss, Jon M\n"
				+ "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "02/10/21\n" + "05/21/21\n" + "M W F \n"
				+ "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n" + "Lambrecht, James M\n"
				+ "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "02/10/21\n" + "05/21/21\n" + "M W F \n"
				+ "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n" + "Lambrecht, James M\n"
				+ "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "02/10/21\n" + "05/21/21\n" + "M W F \n"
				+ "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n" + "Lambrecht, James M\n"
				+ "MULS-200-PN-RE\n" + "Piano\n" + "2.00000\n" + "02/10/21\n" + "05/21/21\n"
				+ " 	 	 	 	 	 	\n" + "Elfline, Robert P\n" + "MUSC-003-01\n" + "Improvisation\n"
				+ "0.00000\n" + "02/10/21\n" + "05/21/21\n" + " 	 	 	 	 	 	\n" + "Granet, Susan L\n"
				+ "MUSC-212-02\n" + "Musicianship IV\n" + "4.00000\n" + "02/10/21\n" + "05/21/21\n" + "M W F \n"
				+ "9:00AM - 10:15AM\n" + " 	 	\n" + "BERG\n" + "LARSON\n" + "Elfline, Robert P\n" + "MUSC-212L-01\n"
				+ "Muscianship IV Lab\n" + "0.00000\n" + "02/10/21\n" + "05/21/21\n" + "Tu Th \n" + "8:20AM - 9:10AM\n"
				+ " 	 	\n" + "BERG\n" + "LARSON\n" + "Ellis, Margaret J";

		String output2 = "[Location: OLIN 208\n" + "Faculty: Mueller, Diane C\n" + "Course Code: CSC-202-01\n"
				+ "Title: Data Structures\n" + "Weekdays: M W F \n" + "Time: 12:00PM - 1:15PM\n"
				+ "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: OLIN 307\n" + "Faculty: Mueller, Diane C\n"
				+ "Course Code: CSC-202L-01\n" + "Title: Lab component of CSC-202\n" + "Weekdays: Tu \n"
				+ "Time: 12:15PM - 2:05PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: OLIN 201\n"
				+ "Faculty: Clauss, Jon M\n" + "Course Code: MATH-450-01\n" + "Title: Algebraic Structures\n"
				+ "Weekdays: M W F \n" + "Time: 1:30PM - 2:45PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n"
				+ "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n" + "Weekdays: Tu Th \n"
				+ "Time: 4:15PM - 5:30PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n"
				+ "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n" + "Weekdays: M W F \n"
				+ "Time: 4:30PM - 5:30PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n"
				+ ", Location: \n" + "Faculty: Elfline, Robert P\n" + "Course Code: MULS-200-PN-RE\n" + "Title: Piano\n"
				+ "Weekdays: \n" + "Time: \n" + "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: \n"
				+ "Faculty: Granet, Susan L\n" + "Course Code: MUSC-003-01\n" + "Title: Improvisation\n"
				+ "Weekdays: \n" + "Time: \n" + "Date: 02/10/21 - 05/21/21\n" + "\n" + ", Location: BERG LARSON\n"
				+ "Faculty: Elfline, Robert P\n" + "Course Code: MUSC-212-02\n" + "Title: Musicianship IV\n"
				+ "Weekdays: M W F \n" + "Time: 9:00AM - 10:15AM\n" + "Date: 02/10/21 - 05/21/21\n" + "\n"
				+ ", Location: BERG LARSON\n" + "Faculty: Ellis, Margaret J\n" + "Course Code: MUSC-212L-01\n"
				+ "Title: Muscianship IV Lab\n" + "Weekdays: Tu Th \n" + "Time: 8:20AM - 9:10AM\n"
				+ "Date: 02/10/21 - 05/21/21\n" + "\n" + "]";

		TextHandler handler2 = new TextHandler(file2);
		System.out.println(handler2.getCourseArray().toString());
		assertEquals(handler2.getCourseArray().toString(), output2);
	}

	@Test
	public void test3() throws IOException {
		String file3 = "SCHEDULE 3\n" + "\n" + "SPST-251-01\n" + "Latino/A Culture in Us\n" + "4.00000\n" + "01/11/21\n"
				+ "02/02/21\n" + "M Tu W Th F \n" + "12:30PM - 4:00PM\n" + " 	 	\n" + "DENK\n" + "301\n"
				+ "Rockwell, Megan E";

		String output3 = "[Location: DENK 301\n" + "Faculty: Rockwell, Megan E\n" + "Course Code: SPST-251-01\n"
				+ "Title: Latino/A Culture in Us\n" + "Weekdays: M Tu W Th F \n" + "Time: 12:30PM - 4:00PM\n"
				+ "Date: 01/11/21 - 02/02/21\n" + "\n" + "]";

		TextHandler handler3 = new TextHandler(file3);
		System.out.println(handler3.getCourseArray().toString());
		assertEquals(handler3.getCourseArray().toString(), output3);
	}

	@Test
	public void test4() throws IOException {
		String file4 = "SCHEDULE 4\n" + "\n" + "ISS-HLDN-02\n" + "Holden Village\n" + "0.00000\n" + "01/03/22\n"
				+ "01/25/22\n" + " 	 	 	 	 	 	\n" + "Bidegaray, Pedro \n" + "RELG-208-HLDN\n"
				+ "Lit & Theology\n" + "4.00000\n" + "01/03/22\n" + "01/25/22\n" + " 	 	 	 	 	 	\n"
				+ "Olsen, Paul V\n" + "";

		String output4 = "[Location: \n" + "Faculty: Bidegaray, Pedro \n" + "Course Code: ISS-HLDN-02\n"
				+ "Title: Holden Village\n" + "Weekdays: \n" + "Time: \n" + "Date: 01/03/22 - 01/25/22\n" + "\n"
				+ ", Location: \n" + "Faculty: Olsen, Paul V\n" + "Course Code: RELG-208-HLDN\n"
				+ "Title: Lit & Theology\n" + "Weekdays: \n" + "Time: \n" + "Date: 01/03/22 - 01/25/22\n" + "\n" + "]";

		TextHandler handler4 = new TextHandler(file4);
		System.out.println(handler4.getCourseArray().toString());
		assertEquals(handler4.getCourseArray().toString(), output4);
	}

	@Test
	public void test5() throws IOException {
		String file5 = "SCHEDULE 5\n" + "\n" + "CSC-201-02\n" + "Intro to Computer Science\n" + "4.00000\n"
				+ "08/31/20\n" + "12/11/20\n" + "M W F \n" + "10:30AM - 11:45AM\n" + " 	 	\n" + "OLIN\n" + "307\n"
				+ "Khan Mohd, Tauheed \n" + "MATH-350-02\n" + "Linear Algebra\n" + "4.00000\n" + "08/31/20\n"
				+ "12/11/20\n" + "M W F \n" + "1:30PM - 2:45PM\n" + " 	 	\n" + "OLIN\n" + "209\n"
				+ "Rodman, Stacey \n" + "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/31/20\n" + "12/11/20\n"
				+ "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/31/20\n"
				+ "12/11/20\n" + "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MUEN-209-NC\n" + "Symphonic Band\n" + "0.00000\n" + "08/31/20\n"
				+ "12/11/20\n" + "M W F \n" + "4:30PM - 5:30PM\n" + "Tu Th \n" + "4:15PM - 5:30PM\n" + "BERG\n" + "ER\n"
				+ "Lambrecht, James M\n" + "MULS-200-PN-RE\n" + "Piano\n" + "2.00000\n" + "08/31/20\n" + "12/11/20\n"
				+ " 	 	 	 	 	 	\n" + "Elfline, Robert P\n" + "MUSC-211-01\n" + "Musicianship III\n"
				+ "4.00000\n" + "08/31/20\n" + "12/11/20\n" + "M W F \n" + "9:00AM - 10:15AM\n" + " 	 	\n"
				+ "BERG\n" + "BLACKBOX\n" + "Cummins, John J\n" + "MUSC-211L-01\n" + "Muscianship III Lab\n"
				+ "0.00000\n" + "08/31/20\n" + "12/11/20\n" + "Tu Th \n" + "8:20AM - 9:10AM\n" + " 	 	\n" + "BERG\n"
				+ "POTTERH\n" + "Ellis, Margaret J\n" + "MUSC-321-01\n" + "Piano Literature\n" + "2.00000\n"
				+ "08/31/20\n" + "12/11/20\n" + " 	 	 	 	 	 	\n" + "Elfline, Robert";

		String output5 = "[Location: OLIN 307\n" + "Faculty: Khan Mohd, Tauheed \n" + "Course Code: CSC-201-02\n"
				+ "Title: Intro to Computer Science\n" + "Weekdays: M W F \n" + "Time: 10:30AM - 11:45AM\n"
				+ "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: OLIN 209\n" + "Faculty: Rodman, Stacey \n"
				+ "Course Code: MATH-350-02\n" + "Title: Linear Algebra\n" + "Weekdays: M W F \n"
				+ "Time: 1:30PM - 2:45PM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n"
				+ "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n" + "Weekdays: M W F \n"
				+ "Time: 4:30PM - 5:30PM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: BERG ER\n"
				+ "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n"
				+ "Weekdays: Tu Th \n" + "Time: 4:15PM - 5:30PM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n"
				+ ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n" + "Course Code: MUEN-209-NC\n"
				+ "Title: Symphonic Band\n" + "Weekdays: M W F \n" + "Time: 4:30PM - 5:30PM\n"
				+ "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: BERG ER\n" + "Faculty: Lambrecht, James M\n"
				+ "Course Code: MUEN-209-NC\n" + "Title: Symphonic Band\n" + "Weekdays: Tu Th \n"
				+ "Time: 4:15PM - 5:30PM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: \n"
				+ "Faculty: Elfline, Robert P\n" + "Course Code: MULS-200-PN-RE\n" + "Title: Piano\n" + "Weekdays: \n"
				+ "Time: \n" + "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: BERG BLACKBOX\n"
				+ "Faculty: Cummins, John J\n" + "Course Code: MUSC-211-01\n" + "Title: Musicianship III\n"
				+ "Weekdays: M W F \n" + "Time: 9:00AM - 10:15AM\n" + "Date: 08/31/20 - 12/11/20\n" + "\n"
				+ ", Location: BERG POTTERH\n" + "Faculty: Ellis, Margaret J\n" + "Course Code: MUSC-211L-01\n"
				+ "Title: Muscianship III Lab\n" + "Weekdays: Tu Th \n" + "Time: 8:20AM - 9:10AM\n"
				+ "Date: 08/31/20 - 12/11/20\n" + "\n" + ", Location: \n" + "Faculty: Elfline, Robert\n"
				+ "Course Code: MUSC-321-01\n" + "Title: Piano Literature\n" + "Weekdays: \n" + "Time: \n"
				+ "Date: 08/31/20 - 12/11/20\n" + "\n" + "]";

		TextHandler handler5 = new TextHandler(file5);
		System.out.println(handler5.getCourseArray().toString());
		assertEquals(handler5.getCourseArray().toString(), output5);
	}

}
