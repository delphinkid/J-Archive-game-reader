package jeopardyReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class clueFinder {
	
	private String category = new String();
	private String clue = new String();
	private String answer = new String();
	private String round = "J";
	private int column = 1;
	private int row = 1;
	private Document doc = null;
	
	public void findClue(webRequest page) {
		
		doc = Jsoup.parse(page.getResponseText());
		if (round.equals("J")) {
			Element categoryElement = doc.getElementsByClass("category_name").get(column-1);
			category = categoryElement.text();
			category = category.replaceAll("&", "and");
		}
		else {
			Element categoryElement = doc.getElementsByClass("category_name").get(column + 5);
			category = categoryElement.text();
		}
		
		Element clueElement = doc.getElementById("clue_" + round + "_" + column + "_" + row);
		//System.out.println(clueElement.text());
		
		if (clueElement != null) {
			clue = clueElement.ownText();
			clue = clue.replaceAll("&", "and");
			clue = clue.replaceAll("<i>", "");
			clue = clue.replaceAll("</i>", "");
		}
		else {
			clue = null;
		}
		
		
		String patternString = "('clue_" + round + "_" + column + "_" + row + "_stuck', .*<em class=&quot;correct_response&quot;>)(.*)(</em><br />)";
		Pattern pattern = Pattern.compile(patternString);
		Matcher match = pattern.matcher(doc.toString());		
		String matchResult = new String();
		while (match.find()) {
			matchResult = match.group(2);
		}
		answer = matchResult;
		answer = answer.replaceAll("&", "and");
		answer = answer.replaceAll("<i>", "");
		answer = answer.replaceAll("</i>", "");
		answer = answer.replaceAll("andquot;", "\"");
		answer = answer.replaceAll("andamp;", "and");
		
	}
	
	public void setColumn(int userColumn) {
		column = userColumn;
	}
	
	public void setRow(int userRow) {
		row = userRow;
	}
	
	public void setRound(String userRound) {
		round = userRound;
	}
	
	public String getClue() {
		return clue;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getRound() {
		return round;
	}

}
