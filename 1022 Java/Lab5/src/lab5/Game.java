package lab5;

/**
 * 
 * <p>Computational thinking for a software developer/computer programmer 
 * is a critical skill that is consistently applied. This lab requires you 
 * to develop a solution using Java object-oriented programming 
 * that simulates a basketball shootout game. </p>
 * <p>Two players agree to limit the number of ball throw attempts to 3 throws each. 
 * The first player will make all three throw attempts 
 * (keep track of the successful baskets made where the ball goes into the basket). </p>
 * <p> After the first player completes all three shots, 
 * the second player will make all three throw attempts. 
 * The player who makes the most baskets (gets the ball in the hoop) will be declared the winner. 
 * In the case of a tie, the tie counter is incremented by one. 
 * Then, the game is repeated until a winner can be determined. 
 * Note that the game can be repeated many times.</p>
 * <p> The losing player of the shootout game will have to give the winning player a move ticket(s). 
 * The number of movie tickets is determined by the total number of baskets made by the winner, 
 * less the total number of baskets made by the losing player. </p>
 * <p> The losing player gives half of a movie ticket for every tied game (if there were any tied games). </p>
 * <p> If the final calculated number of movie tickets has a decimal value, it should be rounded to 
 * the nearest whole number since you can't purchase half a ticket!</p>
 * <p> Example: If the player1 made a total of 3 baskets, and player2 made a total of 2, 
 * and they had three tied games, the number of movie tickets would initially be {@code 3-2=1}, 
 * but increased by {@code 3 x 0.5=1.5}, making the owed number of tickets {@code 2.5} which must be 
 * rounded up to 3 movie tickets.</p>

 * 
 * <p> Requirements: - Any use of Java library classes or methods (e.g., ArrayList,
 * System.arraycopy) is forbidden. (That is, there must not be an import
 * statement in the beginning of this class.) Violation of this requirement will
 * result in a 50% penalty of your marks.</p>
 * <p>
 * - Use only if-statements and/or loops to manipulate primitive arrays (e.g.,
 * int[], String[]).
 * </p>
 */

public class Game {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	/**
	 * Two players agree to limit the number of ball throw attempts to 3 throws
	 * each. Constant value
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private final static int NUMOFATTEMPT = 3;

	/**
	 * The player1name is used to store the player name. The default value will be
	 * used if the name is not given to the player
	 * <p>
	 * The default value is <strong> <code>Unknown</code></strong>
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private String player1Name;

	/**
	 * The player2name is used to store the player name. The default value will be
	 * used if the name is not given to the player
	 * <p>
	 * The default value is <strong> <code>Unknown</code></strong>
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private String player2Name;

	/**
	 * The player1Attempt array is dynamically allocated at run time to store the
	 * result from player1 attempts
	 * <p>
	 * The default value is <strong> <code>false</code></strong> for each attempt
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private boolean[] player1Attempt;
	/**
	 * The player2Attempt array is dynamically allocated at run time to store the
	 * result from player2 attempts
	 * <p>
	 * The default value is <strong> <code>false</code></strong> for each attempt
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private boolean[] player2Attempt;

	/**
	 * The numberofTie is a counter to keep track of the number of tie games.
	 * <p>
	 * The default value is <strong> <code>zero</code></strong> before starting the
	 * game
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int numberofTie;

	/**
	 * String Status keeps track of the current situation or status of the game.
	 * <p>
	 * This string changes during the game to reflect the game status.
	 * </p>
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private String status;

	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	public Game(String player1Name, String player2Name){
		
		if(player2Name == "") {
			player2Name = "Unknown";
		}
		if(player1Name == "") {
			player1Name = "Unknown";
		}
		
		this.player1Name = player1Name;
		this.player2Name = player2Name;
		this.numberofTie = 0;
		this.player1Attempt = new boolean[3];
		this.player2Attempt = new boolean[3];
		
		this.status = String.format("The game was initialized with player1(%s) and player2(%s)", this.player1Name, this.player2Name);
		
		
	}
	
	public Game() {
		
		this.player1Name = "Unknown";
		this.player2Name = "Unknown";
		this.numberofTie = 0;
		this.player1Attempt = new boolean[NUMOFATTEMPT];
		this.player2Attempt = new boolean[NUMOFATTEMPT];
		
		this.status = "The game was initialized with unknown players";
	}
	
	
	public void setPlayer1Name(String name) {
		this.player1Name = name;
		this.status = "Player1 name is set";
	}
	
	public void setPlayer2Name(String name) {
		this.player2Name = name;
		this.status = "Player2 name is set";
	}
	
	public String getPlayer1Name() {
		return this.player1Name;
	}
	public String getPlayer2Name() {
		return this.player2Name;
	}
	
	public String getGameStatus() {
		return this.status;
	}
	
	public void setPlayer1AttempttoSucess(int attemptno) {
		if(attemptno <= 2 && attemptno >= 0) {
			this.player1Attempt[attemptno] = true;
			this.status = String.format("Player1 score attempt number (%d)", attemptno);
		}
	}
	public void setPlayer1AttempttoFail(int attemptno) {
		if(attemptno <= 2 && attemptno >= 0) {
			this.player1Attempt[attemptno] = false;
			this.status = String.format("Player1 fail to score attempt number (%d)", attemptno);
		}
	}
	public void setPlayer2AttempttoSucess(int attemptno) {
		if(attemptno <= 2 && attemptno >= 0) {
			this.player2Attempt[attemptno] = true;
			this.status = String.format("Player2 score attempt number (%d)", attemptno);
		}
	}
	public void setPlayer2AttempttoFail(int attemptno) {
		if(attemptno <= 2 && attemptno >= 0) {
			this.player2Attempt[attemptno] = false;
			this.status = String.format("Player2 fail to score attempt number (%d)", attemptno);
		}
	}
	public int getNoofMovieTicket() {
		int tickets = 0;
		int p1score = 0;
		
		for(int i = 0; i < player1Attempt.length; i++) {
			if(player1Attempt[i] == true)
				p1score += 1;
		}
		
		int p2score = 0;
		for(int i = 0; i < player2Attempt.length; i++) {
			if(player2Attempt[i] == true)
				p2score += 1;
		}
		if(p1score == p2score) {
			this.numberofTie += 1;
			this.status = String.format("The game is tied with no winner. Player1(%d)==Pleyer2(%d). Reset the game.", p1score, p2score);
			return tickets;
		}
		if(p1score > p2score) {
			tickets = (int) Math.round(p1score - p2score + 0.5*this.numberofTie);
			this.status = String.format("Player1 won the game. Player2 should pay (%d) movie tickets.", tickets);
		}
		if(p2score > p1score) {
			tickets = (int) Math.round(p2score - p1score + 0.5*this.numberofTie);
			this.status = String.format("Player2 won the game. Player1 should pay (%d) movie tickets.", tickets);
		}
		return tickets;
	}
	
	
	
	

}
