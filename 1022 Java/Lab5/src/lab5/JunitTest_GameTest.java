package lab5;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;


import org.junit.FixMethodOrder;
import org.junit.Rule;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//ALREADY IMPLEMENTED; DO NOT MODIFY 
// NO NEED TO SUBMIT THIS FILE

/*
 * Tests included in this class serve as documentation on how instances of a
 * Game work.
 * 
 * Be sure to also read the Lab5 instructions PDF carefully
 * 
 * Programming IDEs such as Eclipse are able to fix such compilation errors for
 * you. However, you are advised to follow the guidance as specified in the
 * written Lab instructions PDF to fix these compilation errors manually,
 * because: 1) it helps you better understand how the intended classes and
 * methods work together; and 2) you may be tested in a written test or exam
 * without the assistance of IDEs.
 * 
 */

public class JunitTest_GameTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	private String getPlayer1Name(Game g) {
		String v = "";
		try {
			Field name = Game.class.getDeclaredField("player1Name");
			name.setAccessible(true);
			v = (String) name.get(g);

		} catch (Exception x) {
			fail("exception occurred trying to get this.getPlayer1Name");
			System.out.println(x);
		}
		return v;
	}

	private String getPlayer2Name(Game g) {
		String v = "";
		try {
			Field name = Game.class.getDeclaredField("player2Name");
			name.setAccessible(true);
			v = (String) name.get(g);

		} catch (Exception x) {
			fail("exception occurred trying to get this.getPlayer2Name");
			System.out.println(x);
		}
		return v;
	}

	private String getGameStatus(Game g) {
		String v = "";
		try {
			Field name = Game.class.getDeclaredField("status");
			name.setAccessible(true);
			v = (String) name.get(g);

		} catch (Exception x) {
			fail("exception occurred trying to get this.getGameStatus");
			System.out.println(x);
		}
		return v;
	}

	private int getNumberofTie(Game g) {
		int v = -1;
		try {
			Field name = Game.class.getDeclaredField("numberofTie");
			name.setAccessible(true);
			v = (int) name.get(g);

		} catch (Exception x) {
			fail("exception occurred trying to get this.getNumberofTie");
			System.out.println(x);
		}
		return v;
	}

	private int getNumberofSucess(Game g, int i) {
		int v = 0;
		try {
			Field[] fields = Game.class.getDeclaredFields();
			for (Field f : fields) {
				Class<?> t = f.getType();
//	            System.out.println("field name : " + f.getName() + " , type : " + t);
				if (t.isArray()) {
					if ((i == 1) && f.getName().equals("player1Attempt")) {
						f.setAccessible(true);
						boolean[] value = boolean[].class.cast(f.get(g));
//	            		System.out.println(Arrays.toString(value));
						for (boolean e : value)
							if (e)
								v++;
//	            		
//	            		
//	            		System.out.format("%s%n"                                + "           Field: %s%n"
//	 	                       + "            Type: %s%n"
//	 	                       + "  Component Type: %s%n",
//	 	                       f, f.getName(), t, t.getComponentType());
					}
					if ((i == 2) && f.getName().equals("player2Attempt")) {
						f.setAccessible(true);
						boolean[] value = boolean[].class.cast(f.get(g));
//	            		System.out.println(Arrays.toString(value));
						for (boolean e : value)
							if (e)
								v++;
//	            		
//	            		
//	            		System.out.format("%s%n"                                + "           Field: %s%n"
//	 	                       + "            Type: %s%n"
//	 	                       + "  Component Type: %s%n",
//	 	                       f, f.getName(), t, t.getComponentType());
					}
				}
			}

		} catch (Exception x) {
			fail("exception occurred trying to get this.getNumberofSucess");
			System.out.println(x);
		}
		return v;
	}
	
	
	@Test
	public void test_0_0_staticFields() {
		try {
			List<Field> fields = Arrays.asList(Game.class.getDeclaredFields());

			int nStatic = 0;
			for (Field f : fields) {
				int mod = f.getModifiers();
				if (Modifier.isStatic(mod)) {
					nStatic++;
				}
			}
			assertTrue("there should be three static fields", nStatic == 1);
		} catch (Exception x) {
			fail("exception occurred trying to get the fields of this class");
		}
	}


	@Test
	public void test_0_0_NumberofFields() {
		Field[] allFields = Game.class.getDeclaredFields();
		assertEquals(7, allFields.length);
	}

	@Test
	public void test_1_0() {
		Game g = new Game();
		String expectedP1Name = "Unknown";

		String errorMsg = String.format(
				"\n Test no-arg constructor failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedstatus = "The game was initialized with unknown players";

		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_1_1() {
		Game g = new Game();
		String expectedP2Name = "Unknown";
		String errorMsg = String.format(
				"\n Test no-arg constructor failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP2Name);
		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

		String expectedstatus = "The game was initialized with unknown players";

		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_1_2() {
		Game g = new Game();
		int expectedTienumber = 0;
		String errorMsg = String.format(
				"\n Test no-arg constructor failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);

	}

	@Test
	public void test_1_3() {
		Game g = new Game();
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test no-arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);
	}

	@Test
	public void test_1_4() {
		Game g = new Game();
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test no-arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

	}

	@Test
	public void test_2_0() {
		Game g = new Game("", "");

		String expectedP1Name = "Unknown";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedstatus = "The game was initialized with player1(Unknown) and player2(Unknown)";

		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_2_1() {
		Game g = new Game("", "");

		String expectedP2Name = "Unknown";
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP2Name);
		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

		String expectedstatus = "The game was initialized with player1(Unknown) and player2(Unknown)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_2_2() {
		Game g = new Game("", "");
		int expectedTienumber = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
	}

	@Test
	public void test_2_3() {
		Game g = new Game("", "");

		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

	}

	@Test
	public void test_2_4() {
		Game g = new Game("", "");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

	}

	@Test
	public void test_3_0() {
		Game g = new Game("Mark", "Eric");
		String expectedP1Name = "Mark";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedstatus = "The game was initialized with player1(Mark) and player2(Eric)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_3_1() {
		Game g = new Game("Mark", "Eric");
		String expectedP2Name = "Eric";
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP2Name);
		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

	}

	@Test
	public void test_3_2() {
		Game g = new Game("Emilia", "Zoey");

		int expectedTienumber = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);

		String expectedstatus = "The game was initialized with player1(Emilia) and player2(Zoey)";

		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_3_3() {
		Game g = new Game("Eric", "Ellie");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		String expectedstatus = "The game was initialized with player1(Eric) and player2(Ellie)";

		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_3_4() {
		Game g = new Game("Mark", "Eric");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

	}

	@Test
	public void test_4_0() {
		Game g = new Game("Ava", "Oliver");

		String expectedP1Name = "Ava";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedP2Name = "Oliver";
		errorMsg = String.format(
				"\n Test arg constructor failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP2Name);
		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

		g.setPlayer1Name("William");
		expectedP1Name = "William";
		errorMsg = String.format("\n Test setPlayer1Name failed to set player name. player1 name is (%s) "
				+ "but correct player name is (%s)", this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedstatus = "Player1 name is set";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_4_1() {
		Game g = new Game("James", "Mia");
		String expectedP1Name = "James";

		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(expectedP1Name));

		String expectedP2Name = "Mia";
		errorMsg = String.format(
				"\n Test arg constructor failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP2Name);
		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

		g.setPlayer2Name("Lucas");

		expectedP2Name = "Lucas";
		errorMsg = String.format("\n Test setPlayer2Name failed to set player name. player2 name is (%s) "
				+ "but correct player name is (%s)", this.getPlayer2Name(g), expectedP2Name);

		assertTrue(errorMsg, this.getPlayer2Name(g).equals(expectedP2Name));

		String expectedstatus = "Player2 name is set";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_4_3() {
		Game g = new Game("Jack", "Ethan");

		String expectedP1Name = "Jack";

		String errorMsg = String.format(
				"\n Test getPlayer1Name failed. Returned player1 name (%s) " + "but correct player name is (%s)",
				this.getPlayer1Name(g), expectedP1Name);

		assertTrue(errorMsg, this.getPlayer1Name(g).equals(g.getPlayer1Name()));

		String expectedstatus = "The game was initialized with player1(Jack) and player2(Ethan)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_4_4() {
		Game g = new Game("Emily", "Aria");

		String expectedP2Name = "Aria";
		String errorMsg = String.format(
				"\n Test getPlayer2Name failed. Returned player2 name (%s) " + "but correct player name is (%s)",
				this.getPlayer2Name(g), expectedP2Name);

		assertTrue(errorMsg, this.getPlayer2Name(g).equals(g.getPlayer2Name()));

	}

	@Test
	public void test_5_0() {
		Game g = new Game("James", "Lucas");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)\n",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		g.setPlayer1AttempttoSucess(0);
		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess failed to set sucess attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)\n",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		String expectedstatus = "Player1 score attempt number (0)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		g.setPlayer1AttempttoSucess(2);
		expectedNoSucess = 2;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess failed to set sucess attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)\n",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		expectedstatus = "Player1 score attempt number (2)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		g.setPlayer1AttempttoSucess(1);
		expectedNoSucess = 3;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess failed to set sucess attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		expectedstatus = "Player1 score attempt number (1)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_5_1() {
		Game g = new Game("James", "Lucas");

		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		g.setPlayer1AttempttoSucess(-1);

		String expectedstatus = "The game was initialized with player1(James) and player2(Lucas)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess should not change sucess attempts for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		g.setPlayer1AttempttoSucess(5);
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess should not change sucess attempts for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		expectedstatus = "The game was initialized with player1(James) and player2(Lucas)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		g.setPlayer1AttempttoSucess(1);
		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess failed to set sucess attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		expectedstatus = "Player1 score attempt number (1)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_5_2() {
		Game g = new Game("James", "Lucas");

		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		g.setPlayer2AttempttoSucess(0);

		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		String expectedstatus = "Player2 score attempt number (0)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		g.setPlayer2AttempttoSucess(2);

		expectedNoSucess = 2;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		expectedstatus = "Player2 score attempt number (2)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

		g.setPlayer2AttempttoSucess(1);

		expectedNoSucess = 3;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		expectedstatus = "Player2 score attempt number (1)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_5_3() {

		Game g = new Game("James", "Lucas");

		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(0);
		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		g.setPlayer2AttempttoSucess(2);
		g.setPlayer2AttempttoSucess(2);
		g.setPlayer2AttempttoSucess(2);
		g.setPlayer2AttempttoSucess(2);

		expectedNoSucess = 2;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);
		
		
		String expectedstatus = "Player2 score attempt number (2)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));

	}

	@Test
	public void test_5_4() {
		Game g = new Game("Luna", "Lily");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoSucess(1);
		g.setPlayer1AttempttoSucess(2);
		expectedNoSucess = 3;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoSucess failed to set sucess attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);

		g.setPlayer1AttempttoFail(0);
		expectedNoSucess = 2;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoFail failed to set fail attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);
		
		
		String expectedstatus = "Player1 fail to score attempt number (0)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		
		
		g.setPlayer1AttempttoFail(1);
		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer1AttempttoFail failed to set fail attempt for player1. Returned number of successful attemps for player1 (%d) "
						+ "but correct number of successful attemps for player1 is (%d)",
				getNumberofSucess(g, 1), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 1) == expectedNoSucess);
		
		expectedstatus = "Player1 fail to score attempt number (1)";
		 
	 errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
	}

	@Test
	public void test_5_5() {
		Game g = new Game("Luna", "Lily");
		int expectedNoSucess = 0;
		String errorMsg = String.format(
				"\n Test arg constructor failed. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);
		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(1);
		g.setPlayer2AttempttoSucess(2);
		expectedNoSucess = 3;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoSucess failed to set sucess attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);

		g.setPlayer2AttempttoFail(0);
		
		String expectedstatus = "Player2 fail to score attempt number (0)";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		
		expectedNoSucess = 2;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoFail failed to set fail attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);
		g.setPlayer2AttempttoFail(1);
		
		
		expectedNoSucess = 1;
		errorMsg = String.format(
				"\n Test setPlayer2AttempttoFail failed to set fail attempt for player2. Returned number of successful attemps for player2 (%d) "
						+ "but correct number of successful attemps for player2 is (%d)",
				getNumberofSucess(g, 2), expectedNoSucess);
		assertTrue(errorMsg, this.getNumberofSucess(g, 2) == expectedNoSucess);
		
		expectedstatus = "Player2 fail to score attempt number (1)";
		 
		errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));	
		
	}
	
	@Test
	public void test_6_0() {
			
		Game g = new Game("Emma", "Lily");
		int expectedNotickets = 0;
		int actualNotickets = g.getNoofMovieTicket();
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);

		
		int expectedTienumber = 1;
		errorMsg = String.format(
				"\n Test getNumberofTie failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
		
		
		String expectedstatus = "The game is tied with no winner. Player1(0)==Pleyer2(0). Reset the game.";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));	
		
		
	}
	
	
	@Test
	public void test_6_1() {
			
		Game g = new Game("Emma", "Naomi");
		
		g.setPlayer1AttempttoSucess(0);

		
		int expectedNotickets = 1;
		int actualNotickets = g.getNoofMovieTicket();
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);
		
		
		int expectedTienumber = 0;
		errorMsg = String.format(
				"\n Test getNumberofTie failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
		
		
		String expectedstatus = "Player1 won the game. Player2 should pay (1) movie tickets.";
		
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));	
		
	}
	
	@Test
	public void test_6_2() {
			
		Game g = new Game("Emma", "Naomi");
		
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoSucess(1);

		
		int expectedNotickets = 2;
		int actualNotickets = g.getNoofMovieTicket();
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);
		
		int expectedTienumber = 0;
		errorMsg = String.format(
				"\n Test getNumberofTie failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
		
		
		String expectedstatus = "Player1 won the game. Player2 should pay (2) movie tickets.";
		
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
	}
	
	
	@Test
	public void test_6_3() {
			
		Game g = new Game("Emma", "Naomi");
		
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoSucess(1);
		g.setPlayer1AttempttoSucess(2);

		
		
		int expectedNotickets = 3;
		int actualNotickets = g.getNoofMovieTicket();
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);
		
		int expectedTienumber = 0;
		errorMsg = String.format(
				"\n Test getNumberofTie failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
		
		String expectedstatus = "Player1 won the game. Player2 should pay (3) movie tickets.";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		
		
	}
	
	
	
	
	@Test
	public void test_6_4() {
			
		Game g = new Game("Emma", "Naomi");
		
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoSucess(1);
		g.setPlayer1AttempttoSucess(2);
		
		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(1);
		g.setPlayer2AttempttoFail(2);
		
		
		int expectedNotickets = 1;
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
				g.getNoofMovieTicket(), expectedNotickets);
		assertTrue(errorMsg, g.getNoofMovieTicket()==expectedNotickets);
		
		String expectedstatus = "Player1 won the game. Player2 should pay (1) movie tickets.";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		
	}
	
	@Test
	public void test_6_5() {
			
		Game g = new Game("Emma", "Naomi");
		
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoFail(1);
		g.setPlayer1AttempttoSucess(2);
		
		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(1);
		g.setPlayer2AttempttoFail(2);
		
		
		int expectedNotickets = 0;
		int actualNotickets = g.getNoofMovieTicket();
		String errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);
		
		String expectedstatus = "The game is tied with no winner. Player1(2)==Pleyer2(2). Reset the game.";
		 
		String errorstatusMsg = String.format(
				"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
				this.getGameStatus(g), expectedstatus);
		assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		int expectedTienumber = 1;
		errorMsg = String.format(
				"\n Test getNumberofTie failed. Returned numberofTie (%d) " + "but correct numberofTie is (%d)",
				this.getNumberofTie(g), expectedTienumber);

		assertTrue(errorMsg, this.getNumberofTie(g) == expectedTienumber);
		
		
		g.setPlayer1AttempttoSucess(0);
		g.setPlayer1AttempttoFail(1);
		g.setPlayer1AttempttoFail(2);
		
		
		g.setPlayer2AttempttoSucess(0);
		g.setPlayer2AttempttoSucess(1);
		g.setPlayer2AttempttoSucess(2);
		
		expectedNotickets = 3;
		actualNotickets = g.getNoofMovieTicket();
		errorMsg = String.format(
				"\n Test getNoofMovieTicket failed to calculate number of movie tickets. Returned (%d) "
						+ "but correct number is (%d)\n",
						actualNotickets, expectedNotickets);
		assertTrue(errorMsg, actualNotickets==expectedNotickets);
		
		 expectedstatus = "Player2 won the game. Player1 should pay (3) movie tickets.";
			 
		 errorstatusMsg = String.format(
					"\n Test Game status failed. Returned status Msg (%s) " + "but correct Msg is  (%s)\n",
					this.getGameStatus(g), expectedstatus);
			assertTrue(errorstatusMsg, this.getGameStatus(g).equals(expectedstatus));
		
		
		
	}
	
	
	
}
