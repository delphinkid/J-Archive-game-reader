package jeopardyReader;

import java.util.Scanner;

public class inputStartPoint {
	
	private String round = "J";
	private int category = 1;
	private int row = 1;
	
	public void promptPosition() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter round, or leave blank to start from beginning:");
		round = userInput.nextLine();
		if (round.equals("")) {
			round = "J";
		}
		System.out.println("Enter number of category:");
		String preCat = userInput.nextLine();
		if (preCat.matches("-?(0|[1-9]\\d*)")) {
			category = Integer.parseInt(preCat);
		}
		System.out.println("Enter number of row:");
		String preRow = userInput.nextLine();
		if (preRow.matches("-?(0|[1-9]\\d*)")) {
			row = Integer.parseInt(preRow);
		}
		System.out.println(round + category + row);
		userInput.close();
		
	}
	
	public String getRound() {
		return round;
	}
	
	public int getCategory() {
		return category;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int resetRow) {
		row = resetRow;
	}
	
	public void setCategory(int resetCategory) {
		category = resetCategory;
	}

}
