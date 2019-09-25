package jeopardyReader;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyWatcher extends KeyAdapter{
	
	boolean isPaused = false;
	public void keyPressed(KeyEvent event) {
		//System.out.println(event.getKeyCode());
		if (event.getKeyCode() == 32) {
			if (isPaused) {
				isPaused = false;
			}
			else {
				isPaused = true;
			}
			
		}
		System.out.println(isPaused);
		
	}

}
