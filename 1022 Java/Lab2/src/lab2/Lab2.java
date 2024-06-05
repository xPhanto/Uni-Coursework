package lab2;

/**
 * Objective: practice  If statements, nested If statements, Demorgan's Law, Data Comparison 
 *
 */
public class Lab2 {
	/**
	 * Takes an integer as the gender of a person, integer age, double weigh, 
	 * double height, and a boolean athlete 
	 * and calculates the needed daily calories for that person as a double.
	 */
	public static double getCalories(int gender,int age,double weight, double height, boolean athlete) 
	 {
		double male = (10*weight) + (6.25*height) - (5*age) + 5;
		double female = (10*weight) + (6.25*height) - (5*age) - 161;
		double multiplier = 1;
		double cals = -1;
		
		if((gender == 1 || gender == 2) && !(age <= 0) && !(weight <= 0) && !(height <= 0) && (athlete == true || athlete == false)) {
			
			if(gender == 1){
				if(athlete == true) {
					multiplier = 1.2;
				}
				cals = male*multiplier;
				
			}
			if(gender == 2) {
				if(athlete == true) {
					multiplier = 1.15;
				}
				cals = female*multiplier;
			}
		}
		
		return cals;
		
	 }

		
	/**
	 * Takes a salary as a double and calculates the tax owed for this salary
	 * returns a double value. 
	 * if the salary is an invalid amount it returns -1.
	 */
	public static double computeTax(double income) {
	    
		double taxOut = -1;
		double tax;
		
		if(income > 0) {
			tax = income*0.1;
			taxOut = tax;
			
			if(income > 7150) {
				tax = (income - 7150 )*0.15;
				taxOut = 715 + tax;
				
				if(income > 29050) {
					tax = (income - 29050 )*0.25;
					taxOut = 4000 + tax;	
					
					if(income > 70350) {
						tax = (income - 70350 )*0.28;
						taxOut = 14325 + tax;
					}
				}
			}
		}
		
		return taxOut;
	}
	
	/**
	 * Takes a date as three integers:day, month, and year.
	 * The method returns a true if he date is valid and false otherwise.
	 * The method checks if the month is valid, and the year is after the year 1000.
	 * It checks if the day is valid according to the month. If the month is february, 
	 * it checks if the year is a leap year
	 */
	public static boolean validDate(int day, int month, int year) {
		boolean vDay = false;
		boolean isLeap = false;
		
		if((1 > month) || (month > 12)) {
			return false;
		}
		if(year < 1000) {
			return false;
		}
		if(day <= 0) {
			return false;
		}
		
		if((year%400 == 0) || ((year % 4 == 0) && !(year % 100 == 0)) ) {
			isLeap = true;
		}
		
		
		if(month == 2){
			if(day == 29) {
				if(isLeap == true) {
					vDay = true;
				}
			}
			if(day < 29) {
				vDay = true;
			}	
		}
		
		if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
			if(day <= 31) {
				vDay = true;
			}
		}
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			if(day <= 30) {
				vDay = true;
			}
		}
		
		if(vDay == true) {
			return true;
		}
		return false;
		
	}
	
}