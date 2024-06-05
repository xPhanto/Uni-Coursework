package lab4;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//ALREADY IMPLEMENTED; DO NOT MODIFY 
//NO NEED TO SUBMIT THIS FILE

/*
* 
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

public class JunitTest_Lab4Test {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	
	@Test
	public void longestSeq1() {
		int[] a = {7,9,10,-3,-2,-1,12,20};
		assertEquals("Failed longestSeq", 3, Lab4.longestSeq(a));
		int[] b = {};
		assertEquals("Failed longestSeq", 0, Lab4.longestSeq(b));
	}
	@Test
	public void longestSeq2() {
		int[] a = {};
		assertEquals("Failed longestSeq", 0, Lab4.longestSeq(a));
		int[] b = {7,8, 9,10,-3,-2,-1,12,20};
		assertEquals("Failed longestSeq", 4, Lab4.longestSeq(b));
	}
	@Test
	public void longestSeq3() {
		int[] a = {7,9,15,-3,-8,-5,12,20};
		assertEquals("Failed longestSeq", 1, Lab4.longestSeq(a));
		int[] b = {5, 6, 7,8, 9,10,0,-2,-1,12,20};
		assertEquals("Failed longestSeq", 6, Lab4.longestSeq(b));
	}
	@Test
	public void longestSeq4() {
		int[] a = {7,9,15,-3,-8,-7,20};
		assertEquals("Failed longestSeq",2, Lab4.longestSeq(a));
		int[] b = {5, 6, 7,8, 9,10,0,-2,-1,12,20};
		assertEquals("Failed longestSeq", 6, Lab4.longestSeq(b));
	}
	@Test
	public void longestSeq5() {
		int[] a = {7,9,15,-3,-2,-8,5,6,7,8,12,13};
		assertEquals("Failed longestSeq",4, Lab4.longestSeq(a));
		int[] b = {5, 6, 10, 0,-2,-1, 12, 13,14, 15, 16};
		assertEquals("Failed longestSeq", 5, Lab4.longestSeq(b));
	}
	@Test
	public void longestSeq6() {
		int[] a = {7,9,15,-3,-2,-1,0,1,5,6,7,8,12,13};
		assertEquals("Failed longestSeq", 5, Lab4.longestSeq(a));
		int[] b =  {-5,-4, -3,-2,-1,0,1};
		assertEquals("Failed longestSeq", 7, Lab4.longestSeq(b));
	}

	@Test
	public void countArray1() {
		int [] a = {2,10,10,98,3,146};
		String expected = "2: 1\n10: 2\n98: 1";
		assertEquals("Failed countArray", expected, Lab4.countArray(a));
		int [] b = {};
		expected = "";
		assertEquals("Failed countArray", expected, Lab4.countArray(b));
	}
	@Test
	public void countArray2() {
		int [] a = {};
		String expected = "";
		assertEquals("Failed countArray", expected, Lab4.countArray(a));
		
		int [] b= {2,2,10,10,98,3,146,2,2};
		expected = "2: 4\n10: 2\n98: 1";
		assertEquals("Failed countArray", expected, Lab4.countArray(b));
	}
	@Test
	public void countArray3() {
		int [] a = {6,12,6,6,18,45};
		String expected = "6: 3\n12: 1\n18: 1";
		assertEquals("Failed countArray", expected, Lab4.countArray(a));
		int [] b= {2,2,10,10,98,3,146,10,2,2};
		expected = "2: 4\n10: 3\n98: 1";
		assertEquals("Failed countArray", expected, Lab4.countArray(b));
	}
	@Test
	public void countArray4() {
		int [] a = {7,13,9,9,19,45};
		String expected = "";
		assertEquals("Failed countArray", expected, Lab4.countArray(a));
		int [] b= {2,2,2,2};
		expected = "2: 4";
		assertEquals("Failed countArray", expected, Lab4.countArray(b));
	}
	@Test
	public void countArray5() {
		int [] a = {6,12,6,6,18,45,18,34,18,18,12};
		String expected = "6: 3\n12: 2\n18: 4\n34: 1";
		assertEquals("Failed countArray", expected, Lab4.countArray(a));
	}

	@Test
	public void validString1() {
		assertEquals("Failed validString", true, Lab4.validString("heeaaalolo", "hello"));
		assertEquals("Failed validString", false, Lab4.validString("hlelo", "hello"));
	}
	@Test
	public void validString2() {
		assertEquals("Failed validString", false, Lab4.validString("hlelo", "hello"));
		assertEquals("Failed validString", true, Lab4.validString("I Love EECS !", "EECS"));
	}
	@Test
	public void validString3() {
		assertEquals("Failed validString", false, Lab4.validString("hlelo", "hello"));
		assertEquals("Failed validString", true, Lab4.validString("I Love Jaaaaav a lot!", "Java"));
	}
	@Test
	public void validString4() {
		assertEquals("Failed validString", false, Lab4.validString("certeedinnnn", "certain"));
		assertEquals("Failed validString", true, Lab4.validString("Are you testing your code", "testing"));
	}
	@Test
	public void validString5() {
		assertEquals("Failed validString", true, Lab4.validString("the name is not written", "now"));
		assertEquals("Failed validString", false, Lab4.validString("Are you testing your code", "Testing"));
	}
	@Test
	public void arrayResult1() {
		int[][] a = {{8,1,6},{3,5,7},{4,9,2}};
		assertEquals("Failed arrayResult", "Sum:25, Product:189", Lab4.arrayResult(a));
	}
	@Test
	public void arrayResult2() {
		int[][] a = {{1}};
		assertEquals("Failed arrayResult", "Sum:1, Product:0", Lab4.arrayResult(a));
		int[][] b = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		assertEquals("Failed arrayResult", "Sum:8, Product:1", Lab4.arrayResult(b));
	}
	@Test
	public void arrayResult3() {
		int[][] a = {};
		assertEquals("Failed arrayResult", "", Lab4.arrayResult(a));
		int[][] b = {{1,2},{2,2}};
		assertEquals("Failed arrayResult", "Sum:3, Product:4", Lab4.arrayResult(b));
	}
	@Test
	public void magicSquare1() {
		int[][] a = { {8, 1, 6},
					  {3, 5, 7},
					  {4, 9, 2} };
		assertEquals("Failed magicSquare", true, Lab4.magicSquare(a));
	}
	@Test
	public void magicSquare2() {
		int[][] a = { {8, 10, 6},
					  {3, 5, 4},
					  {4, 9, 2} };
		assertEquals("Failed magicSquare", false, Lab4.magicSquare(a));
	}
	@Test
	public void magicSquare3() {
		int[][] a = {{1}};
		assertEquals("Failed magicSquare", true, Lab4.magicSquare(a));
	}
	@Test
	public void magicSquare4() {
		int[][] a = { {3, 16, 2, 13},
					  {6,  9, 7, 12},
					  {10, 5, 11, 8},
					  {15, 4, 14, 1} };
		assertEquals("Failed magicSquare", false, Lab4.magicSquare(a));
	}
	@Test
	public void magicSquare5() {
		int[][] a = { {7, 12, 1, 14},
					  {2, 13, 8, 11},
					  {16, 3, 10, 5},
					  {9,  6, 15, 4} };
		assertEquals("Failed magicSquare", true, Lab4.magicSquare(a));
	}

}
