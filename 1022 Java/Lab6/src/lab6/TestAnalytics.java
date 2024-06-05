package lab6;

import java.util.Arrays;
import java.lang.String;
import java.lang.Character;

public class TestAnalytics {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private final static int NUMOFQUESTIONs = 50;
	private final static int MARKFORQUESTION = 2;
	private final static int NUMOFQUESTIONCHOICES = 4;
	private final static String TESTCORRECTANSWER = "D,C,A,D,A,B,C,D,B,C,A,B,D,C,A,A,"
			+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,C,C,C," + "A,B,A,B,B,C,A,B,A,A,D,C";

	
	// TODO: Your implementation starts here
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private String[] info;
	private int grade;
	private int score;
	
	public TestAnalytics(String studentTest){
		this.info = studentTest.split(",");
		this.grade = 0;
		this.score = 0;

	}
	
	public String getStudentName() {
		String name = this.info[0];
		return name;
	}
	
	public String getStudentID() {
		String id = this.info[1];
		return id;
	}
	
	public String getStudentAnswer() {
		String[] ansCopy = Arrays.copyOfRange(this.info, 2, this.info.length);
		String answer = String.join(",", ansCopy);
		return answer;
		// I could also have removed the first two terms from the array, I am aware.
		// However, util.Arrays is allowed and I wanted to try this way.
	}
	public int calculateStudentGrade() {
		int numCorrect = 0;
		
		String[] studentA = Arrays.copyOfRange(this.info, 2, this.info.length);
		String[] aKey = TESTCORRECTANSWER.split(",");
		
		for(int i = 0; i < NUMOFQUESTIONs; i++) {
			char expected = Character.toLowerCase(aKey[i].charAt(0));
			char actual = Character.toLowerCase(studentA[i].charAt(0));
			if(expected == actual) {
				numCorrect += 1;
			}
		}
		this.grade = numCorrect*MARKFORQUESTION;
		this.score = numCorrect;
		
		return this.grade;
	}
	public String getStudentAnswerFrequency() {
		int fa = 0;
		int fb = 0;
		int fc = 0;
		int fd = 0;
		
		String[] studentA = Arrays.copyOfRange(this.info, 2, this.info.length);
		
		for(int i = 0; i < studentA.length; i++) {
			char ans = Character.toLowerCase(studentA[i].charAt(0));
			if(ans == 'a') {
				fa++;
			}
			if(ans == 'b') {
				fb++;
			}
			if(ans == 'c') {
				fc++;
			}
			if(ans == 'd') {
				fd++;
			}
		}
		String status = String.format("The frequency of the student(%s) answer is A(%d), B(%d), C(%d) and D(%d).", this.info[0], fa, fb, fc, fd);
		
		return status;
		
	}
	
	public String toString() {
		String result = "";
		
		this.calculateStudentGrade();
		
		double formattedScore = ((double) this.score / NUMOFQUESTIONs) * 100;
		
		if(this.grade >= 50) {
			result = String.format("Student(%s) passed the test. %s answered (%d) correct questions and scored ( %.2f) out of 100.", this.getStudentName(), this.getStudentName(), this.score, formattedScore);
		} else {
			result = String.format("Student(%s) failed the test. %s answered (%d) correct questions and scored ( %.2f) out of 100.", this.getStudentName(), this.getStudentName(), this.score, formattedScore);
		}
		
		
		return result;
	}

}
