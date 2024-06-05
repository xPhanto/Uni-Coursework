package lab2;

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
public class JunitTest_Lab2Test {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void testgetCalories1() {
		double calories = Lab2.getCalories(1, 25, 70.0, 170.0, false);
		assertEquals("Failed getCalories 1", 1642.5, calories, 0.0001);
	}

	@Test
	public void testgetCalories2() {
		double calories = Lab2.getCalories(2, 35, 60.0, 160.0, false);
		assertEquals("Failed getCalories 2", 1264.0, calories, 0.0001);
	}

	@Test
	public void testgetCalories3() {
		double calories = Lab2.getCalories(1, 25, 70.0, 170.0, true);
		assertEquals("Failed getCalories 3", 1971.0, calories, 0.0001);
	}

	@Test
	public void testgetCalories4() {
		double calories = Lab2.getCalories(2, 35, -52.6, 145.3, true);
		assertEquals("Failed getCalories 4", -1, calories, 0.0001);
	}

	@Test
	public void testgetCalories5() {
		double calories = Lab2.getCalories(3, 35, 52.6, 145.3, true);
		assertEquals("Failed getCalories 5", -1, calories, 0.0001);
	}

	@Test
	public void testgetCalories6() {
		double calories = Lab2.getCalories(1, 50, 65.0, -167.0, true);
		assertEquals("Failed getCalories 6", -1, calories, 0.0001);
	}

	@Test
	public void testgetCalories7() {
		double calories = Lab2.getCalories(1, 0, 65.0, -150, true);
		assertEquals("Failed getCalories 7", -1, calories, 0.0001);
	}
	@Test
	public void testgetCalories8() {
		double calories = Lab2.getCalories(2, 35, 65.0, 150, true);
		assertEquals("Failed getCalories 8", 1439.225, calories, 0.0001);
	}

	@Test
	public void computeTax1() {
		double tax = Lab2.computeTax(50000.0);
		assertEquals("Failed computeTax 1", 9237.5, tax, 0.0001);
	}

	@Test
	public void computeTax2() {
		double tax = Lab2.computeTax(6000.0);
		assertEquals("Failed computeTax 2", 600.0, tax, 0.0001);
	}

	@Test
	public void computeTax3() {
		double tax = Lab2.computeTax(120000.0);
		assertEquals("Failed computeTax 3", 28227.0, tax, 0.0001);
	}

	@Test
	public void computeTax4() {
		double tax = Lab2.computeTax(-15000.0);
		assertEquals("Failed computeTax 4", -1.0, tax, 0.0001);
	}

	@Test
	public void computeTax5() {
		double tax = Lab2.computeTax(7150.0);
		assertEquals("Failed computeTax 5", 715.0, tax, 0.0001);
	}

	@Test
	public void computeTax6() {
		double tax = Lab2.computeTax(29050.0);
		assertEquals("Failed computeTax 6", 4000.0, tax, 0.0001);
	}

	@Test
	public void computeTax7() {
		double tax = Lab2.computeTax(27500.0);
		assertEquals("Failed computeTax 7", 3767.50, tax, 0.0001);
	}

	@Test
	public void validDate1() {
		boolean valid = Lab2.validDate(31, 2, 2022);
		assertEquals("Failed validDate", false, valid);
		valid = Lab2.validDate(31, 3, 1765);
		assertEquals("Failed validDate", true, valid);
		
	}

	@Test
	public void validDate2() {
		boolean valid = Lab2.validDate(31, 3, 1765);
		assertEquals("Failed validDate", true, valid);
		valid = Lab2.validDate(31, 2, 2022);
		assertEquals("Failed validDate", false, valid);
	}

	@Test
	public void validDate3() {
		boolean valid = Lab2.validDate(29, 2, 1600);
		assertEquals("Failed validDate", true, valid);
		valid = Lab2.validDate(29, 2, 2021);
		assertEquals("Failed validDate", false, valid);
	}

	@Test
	public void validDate4() {
		boolean valid = Lab2.validDate(29, 2, 2022);
		assertEquals("Failed validDate", false, valid);
		valid = Lab2.validDate(29, 2, 1512);
		assertEquals("Failed validDate", true, valid);
	}

	@Test
	public void validDate5() {
		boolean valid = Lab2.validDate(0, 2, 2022);
		assertEquals("Failed validDate", false, valid);
		valid = Lab2.validDate(23, 2, 2012);
		assertEquals("Failed validDate", true, valid);
	}

	@Test
	public void validDate6() {
		boolean valid = Lab2.validDate(29, 0, 2022);
		assertEquals("Failed validDate6", false, valid);
		valid = Lab2.validDate(23, 1, 2012);
		assertEquals("Failed validDate", true, valid);
	}

	@Test
	public void validDate7() {
		boolean valid = Lab2.validDate(12, 10, 876);
		assertEquals("Failed validDate6", false, valid);
		valid = Lab2.validDate(23, 2, 2014);
		assertEquals("Failed validDate", true, valid);
	}
	
	@Test
	public void validDate8() {
		boolean valid = Lab2.validDate(31, 11, 1080);
		assertEquals("Failed validDate8", false, valid);
		valid = Lab2.validDate(12, 11, 1765);
		assertEquals("Failed validDate", true, valid);
		
	}
	
	@Test
	public void validDate9() {
		boolean valid = Lab2.validDate(12, 6, 900);
		assertEquals("Failed validDate", false, valid);
		valid = Lab2.validDate(29, 6, 2000);
		assertEquals("Failed validDate", true, valid);
		
	}

}
