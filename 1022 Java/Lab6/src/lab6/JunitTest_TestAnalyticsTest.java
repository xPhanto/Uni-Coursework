package lab6;

import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//ALREADY IMPLEMENTED; DO NOT MODIFY 
//NO NEED TO SUBMIT THIS FILE

/*
 * Tests included in this class serve as documentation on how instances of a
 * Test Analytics work.
 * 
 * Be sure to also read the Lab instructions PDF carefully
 * 
 * Programming IDEs such as Eclipse are able to fix such compilation errors for
 * you. However, you are advised to follow the guidance as specified in the
 * written Lab instructions PDF to fix these compilation errors manually,
 * because: 1) it helps you better understand how the intended classes and
 * methods work together; and 2) you may be tested in a written test or exam
 * without the assistance of IDEs.
 * 
 */

public class JunitTest_TestAnalyticsTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	
	// test the number of static attributes 
	@Test
	public void test_0_0_staticFields() {
		try {
			List<Field> fields = Arrays.asList(TestAnalytics.class.getDeclaredFields());

			int nStatic = 0;
			for (Field f : fields) {
				int mod = f.getModifiers();
				if (Modifier.isStatic(mod)) {

					nStatic++;
				}
			}
			assertTrue("there should be four static fields", nStatic == 4);
		} catch (Exception x) {
			fail("exception occurred trying to get the fields of this class");
		}
	}

	
	@Test
	public void test_1_0() {
		//The test system generates this string as a result of student's attempt 
		String stdtest = "James,789654,A,C,B,A,C,B,B,A,D,B,D,A,D,B,C,B,D,B,"
				+ "B,A,D,A,C,B,A,A,C,A,A,D,D,C,C,D,C,A,D,A,D,C,A,C,A,D,D,C,C,B,B,D";

		// construct the TestAnalytics object
		TestAnalytics t1 = new TestAnalytics(stdtest);
		String expectedstdName = "James";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned stduent name (%s) " + "but correct name is (%s)",
				t1.getStudentName(), expectedstdName);
		assertTrue(errorMsg, t1.getStudentName().equals(expectedstdName));

	}

	@Test
	public void test_1_2() {
		String stdtest = "James,789654,A,C,B,A,C,B,B,A,D,B,D,A,D,B,C,B,D,B,"
				+ "B,A,D,A,C,B,A,A,C,A,A,D,D,C,C,D,C,A,D,A,D,C,A,C,A,D,D,C,C,B,B,D";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedstdID = "789654";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned stduent ID (%s) " + "but correct ID is (%s)",
				t1.getStudentID(), expectedstdID);
		assertTrue(errorMsg, t1.getStudentID().equals(expectedstdID));

	}

	@Test
	public void test_1_3() {
		String stdtest = "James,789654,A,C,B,A,C,B,B,A,D,B,D,A,D,B,C,B,D,B,"
				+ "B,A,D,A,C,B,A,A,C,A,A,D,D,C,C,D,C,A,D,A,D,C,A,C,A,D,D,C,C,B,B,D";

		TestAnalytics t1 = new TestAnalytics(stdtest);
		
		// make sure you extracted the student answers correctly 

		String expectedstdAns = "A,C,B,A,C,B,B,A,D,B,D,A,D,B,C,B,D,B,B,A,D,A,C,B,"
				+ "A,A,C,A,A,D,D,C,C,D,C,A,D,A,D,C,A,C,A,D,D,C,C,B,B,D";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned stduent Answer (%s) " + "but correct Answer is (%s)",
				t1.getStudentAnswer(), expectedstdAns);

		assertTrue(errorMsg, t1.getStudentAnswer().equals(expectedstdAns));

	}

	@Test
	public void test_2_0() {
		String stdtest = "James,789654,D,C,A,D,A,B,C,D,B,C,A,B,D,C,A,A,"
				+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,C,C,C,A,B,A,B,B,C,A,B,A,A,D,C";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		double expectedstdGrade = 100.0;
		final double THRESHOLD = .01;
		// test the student grade 
		double stdGrade = t1.calculateStudentGrade();
		String errorMsg = String.format(
				"\n Test  findStudentGrade failed. Returned stduent Answer (%6.2f) " + "but correct Answer is (%6.2f)",
				stdGrade, expectedstdGrade);
		  

		assertTrue(errorMsg, Math.abs(expectedstdGrade - stdGrade) < THRESHOLD);

	}

	@Test
	public void test_2_1() {
		String stdtest = "Robert,124554,D,C,A,D,A,B,C,C,B,C,A,B,D,C,A,A,"
				+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,C,C,C,A,B,A,B,B,C,A,B,A,A,D,C";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		double expectedstdGrade = 98.0;
		final double THRESHOLD = .01;
		double stdGrade = t1.calculateStudentGrade();
		String errorMsg = String.format(
				"\n Test  findStudentGrade failed. Returned stduent Answer (%6.2f) " + "but correct Answer is (%6.2f)",
				stdGrade, expectedstdGrade);
		  
		assertTrue(errorMsg, Math.abs(expectedstdGrade - stdGrade) < THRESHOLD);

	}

	@Test
	public void test_2_3() {
		String stdtest = "David,9632587,D,C,A,D,A,B,C,C,B,C,A,B,D,C,A,A,"
				+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,c,c,c,a,b,b,b,c,a,b,a,a,d,a,d";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		double expectedstdGrade = 82.0;
		final double THRESHOLD = .01;
		double stdGrade = t1.calculateStudentGrade();

		String errorMsg = String.format(
				"\n Test  findStudentGrade failed. Returned stduent Answer (%6.2f) " + "but correct Answer is (%6.2f)",
				stdGrade, expectedstdGrade);
		 
		assertTrue(errorMsg, Math.abs(expectedstdGrade - stdGrade) < THRESHOLD);

	}

	@Test
	public void test_2_4() {

		String stdtest = "Richard,852369,d,a,a,D,D,d,b,D,b,c,d,D,d,B,B,D,b,d,"
				+ "c,D,A,B,a,D,b,a,C,a,C,C,c,c,b,b,a,a,c,C,d,b,d,b,A,d,D,c,A,C,c,C";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		double expectedstdGrade = 36.0;
		final double THRESHOLD = .01;
		double stdGrade = t1.calculateStudentGrade();

		String errorMsg = String.format(
				"\n Test  findStudentGrade failed. Returned stduent Answer (%6.2f) " + "but correct Answer is (%6.2f)",
				stdGrade, expectedstdGrade);
		 
		assertTrue(errorMsg, Math.abs(expectedstdGrade - stdGrade) < THRESHOLD);

	}

	@Test
	public void test_2_5() {

		String stdtest = "William,7854123,d,a,d,d,b,d,a,b,d,b,b,d,b,b,"
				+ "b,b,d,d,a,c,b,a,d,b,d,c,c,a,a,c,a,c,c,a,d,c,d,c,c,a,a,c,d,d,b,a,a,a,a,b";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		double expectedstdGrade = 22.0;
		final double THRESHOLD = .01;
		double stdGrade = t1.calculateStudentGrade();

		String errorMsg = String.format(
				"\n Test  findStudentGrade failed. Returned stduent Answer (%6.2f) " + "but correct Answer is (%6.2f)",
				stdGrade, expectedstdGrade);
		 
		assertTrue(errorMsg, Math.abs(expectedstdGrade - stdGrade) < THRESHOLD);

	}

	@Test
	public void test_3_0() {

		String stdtest = "William,85974,b,d,a,c,d,c,b,d,b,c,d,b,d,c,a,a,d,b,d,b,d,c,d,b,"
				+ "d,d,d,d,c,c,a,b,d,c,a,d,c,d,c,b,c,c,d,b,b,c,a,a,b,d";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedstdfrq = "The frequency of the student(William) answer is A(7), B(12), C(13) and D(18).";
		String stdfrq =  t1.getStudentAnswerFrequency();
		 

		String errorMsg = String.format(
				"\n Test getStudentAnswerFrequency failed. Returned stduent answer frequency (%s) " + "but correct frq is (%s)",
				stdfrq, expectedstdfrq);
		assertTrue(errorMsg, stdfrq.equals(expectedstdfrq));

	}
	
	
	@Test
	public void test_3_1() {

		String stdtest = "Daniel,852369,C,B,C,A,A,D,B,C,C,A,B,C,C,D,B,A,C,B,C,C,D,C,"
				+ "C,A,B,C,C,D,D,D,D,C,A,A,D,B,C,D,C,C,C,A,A,B,D,D,C,B,D,C";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedstdfrq = "The frequency of the student(Daniel) answer is A(9), B(9), C(20) and D(12).";
		String stdfrq =  t1.getStudentAnswerFrequency();
		 

		String errorMsg = String.format(
				"\n Test getStudentAnswerFrequency failed. Returned stduent answer frequency (%s) " + "but correct frq is (%s)",
				stdfrq, expectedstdfrq);
		assertTrue(errorMsg, stdfrq.equals(expectedstdfrq));

	}

	
	@Test
	public void test_3_2() {

		String stdtest = "Matthew,12548796,a,C,B,a,a,a,c,D,a,D,C,d,c,B,D,c,D,A,"
				+ "b,D,a,D,c,d,A,c,C,a,D,a,D,d,A,D,A,A,B,d,B,C,B,D,d,B,C,B,c,C,D,B";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedstdfrq = "The frequency of the student(Matthew) answer is A(13), B(9), C(12) and D(16).";
		String stdfrq =  t1.getStudentAnswerFrequency();
		 

		String errorMsg = String.format(
				"\n Test getStudentAnswerFrequency failed. Returned stduent answer frequency (%s) " + "but correct frq is (%s)",
				stdfrq, expectedstdfrq);
		assertTrue(errorMsg, stdfrq.equals(expectedstdfrq));

	}
	
	@Test
	public void test_4_0() {

		String stdtest = "William,85974,b,d,a,c,d,c,b,d,b,c,d,b,d,c,a,a,d,b,d,b,d,c,d,b,"
				+ "d,d,d,d,c,c,a,b,d,c,a,d,c,d,c,b,c,c,d,b,b,c,a,a,b,d";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedteststr = "Student(William) failed the test. William answered (15) correct questions and scored ( 30.00) out of 100.";
		String testAnaStr =  t1.toString();
		 

		String errorMsg = String.format(
				"\n Test toString failed. Returned string (%s) " + "but correct string is (%s)",
				testAnaStr, expectedteststr);
		assertTrue(errorMsg, testAnaStr.equals(expectedteststr));

	}
	
	
	@Test
	public void test_4_2() {

		String stdtest = "Anthony,852364,a,A,A,A,B,c,D,c,a,d,d,D,b,b,A,B,D,d,c,b,b,c,"
				+ "a,d,b,D,D,d,A,b,A,d,B,b,b,c,c,B,C,D,C,b,d,B,c,c,d,B,d,D";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedteststr = "Student(Anthony) failed the test. Anthony answered (12) correct questions and scored ( 24.00) out of 100.";
		String testAnaStr =  t1.toString();
		 

		String errorMsg = String.format(
				"\n Test toString failed. Returned string (%s) " + "but correct string is (%s)",
				testAnaStr, expectedteststr);
		assertTrue(errorMsg, testAnaStr.equals(expectedteststr));

	}
	
	@Test
	public void test_4_3() {


		String stdtest = "Robert,124554,D,C,A,D,A,B,C,C,B,C,A,B,D,C,A,A,"
				+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,C,C,C,A,B,A,B,B,C,A,B,A,A,D,C";

		TestAnalytics t1 = new TestAnalytics(stdtest);

		String expectedteststr = "Student(Robert) passed the test. Robert answered (49) correct questions and scored ( 98.00) out of 100.";
		String testAnaStr =  t1.toString();
		 

		String errorMsg = String.format(
				"\n Test toString failed. Returned string (%s) " + "but correct string is (%s)",
				testAnaStr, expectedteststr);
		assertTrue(errorMsg, testAnaStr.equals(expectedteststr));

	}
	
}
