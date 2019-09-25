package jeopardyReader;

import java.awt.*;

import javax.swing.*;

public class windowPopper {
	JLabel text = new JLabel("Jeopardy", SwingConstants.CENTER);
	JLabel catText = new JLabel("Round 1", SwingConstants.CENTER);
	keyWatcher key = new keyWatcher();
	boolean isPaused = false;
	public void openWindow() {
		JFrame frame = new JFrame("Game Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 720);
		text.setFont(new Font("Arial", Font.PLAIN, 50));
		catText.setFont(new Font("Arial", Font.BOLD, 50));
		catText.setBounds(0,100,1000,100);
		frame.addKeyListener(key);
		frame.getContentPane().add(catText);
		frame.getContentPane().add(text);
		frame.setVisible(true);
	}
	
}
