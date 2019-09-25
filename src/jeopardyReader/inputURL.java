package jeopardyReader;

import java.util.Scanner;

public class inputURL {
	private String gameId = new String();
	
	public void promptId() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the ID for the game you wish to play:");
		gameId = userInput.nextLine();
		//userInput.close();
	}
	
	public String getGameId() {
		return gameId;
	}

}
