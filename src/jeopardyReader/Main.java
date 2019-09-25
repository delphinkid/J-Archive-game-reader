package jeopardyReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		inputURL prompt = new inputURL();
		prompt.promptId();
		inputStartPoint resumePrompt = new inputStartPoint();
		resumePrompt.promptPosition();
		windowPopper window = new windowPopper();
		window.openWindow();
		
		webRequest page = new webRequest();
		page.setUrlString("http://www.j-archive.com/showgame.php?game_id=" + prompt.getGameId());
		try {
			page.loadPage();			
		}
		catch (Exception e) {
			
		}
		
		System.setProperty("mbrola.base", "C:/Users/Eli/eclipse-workspace/mbrola");
		speaker voice = new speaker("cmu-rms-hsmm");
		clueFinder clues = new clueFinder();

		clues.setRow(resumePrompt.getCategory());
		clues.setRound(resumePrompt.getRound());
		String html = "<html><body style='width: %1spx'>%1s";
		boolean isPaused = window.key.isPaused;
		for (int r = 0; r<2; r++) {
			if (clues.getRound().equals("DJ")) {
				r = 1;
			}
			for (int x = resumePrompt.getCategory(); x<7; x++) {
				clues.setColumn(x);
				clues.findClue(page);
				//System.out.println(clues.getCategory());
				
				window.catText.setText(clues.getCategory());
				voice.say(clues.getCategory());
				Thread.sleep(2000);
				for (int y = resumePrompt.getRow(); y<6; y++) {
					clues.setRow(y);
					clues.findClue(page);
					isPaused = window.key.isPaused;
					//System.out.println(window.key.isPaused);
					while (isPaused) {
						isPaused = window.key.isPaused;	
						Thread.sleep(100);
					}
					if (clues.getClue() != null) {
						window.text.setText(String.format(html, 700, clues.getClue()));
						voice.say(clues.getClue());
						Thread.sleep(4000);
						isPaused = window.key.isPaused;
						//System.out.println(window.key.isPaused);
						while (isPaused) {
							isPaused = window.key.isPaused;	
							Thread.sleep(100);
						}
						//System.out.println("What is " + clues.getAnswer());
						window.text.setText(String.format(html, 700, "What is "+clues.getAnswer()));
						voice.say("What is " + clues.getAnswer());
						Thread.sleep(3000);
						
					}			
					
				}
				resumePrompt.setRow(1);
				
			}
			resumePrompt.setCategory(1);
			if (clues.getRound().equals("J")) {
				voice.say("Double Jeopardy");
			}
			else {
				voice.say("The end");
			}
			clues.setRound("DJ");
			
		}

	}

}
