package lab2;

/**
 * Objective: practice  If statements, nested If statements, Demorgan's Law, Data Comparison 
 *
 */

	public class UniversityMember {
		String name;
		public String toString() {
			return "A University Member";
		}
		public static void main(String[] args) {
			Object obj = new Object();
			UniversityMember me = new UniversityMember();
			Student she = new Student();
			Staff he = new Staff();
			Undergraduate you = new Undergraduate();
			Graduate they = new Graduate();
			
			Undergraduate john = new Undergraduate();
			Student jane = new Undergraduate();
			UniversityMember jack = new Undergraduate();
			Object jade = new Undergraduate();
			
			Graduate rose = new Graduate();
			Student rory = new Graduate();
			UniversityMember roy = new Graduate();
			Object richard = new Graduate();
			
			System.out.println(obj);
			System.out.println(john);
			System.out.println(me);
			System.out.println(roy);
			System.out.println(rory);
			System.out.println(john);
			System.out.println(she);
			System.out.println(jack);
			System.out.println(he);
			System.out.println(rose);
			System.out.println(you);
			System.out.println(jane);
			System.out.println(they);
			System.out.println(richard);
			System.out.println(jade);
		}
	}
	
	class Student extends UniversityMember{
	}
	
	class Staff extends UniversityMember{
		public String toString() {
			return "a Staff";
		}
	}
	class Undergraduate extends Student{
		public String toString() {
			return "an undergrad";
		}
	}
	class Graduate extends Student {
	}
	
	






