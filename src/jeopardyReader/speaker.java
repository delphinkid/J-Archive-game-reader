package jeopardyReader;

import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.util.data.audio.AudioPlayer;

public class speaker {

	private MaryInterface marytts;
	private AudioPlayer ap;
	
	public speaker(String voiceName) {
		
		try {
			marytts = new LocalMaryInterface();
			marytts.setVoice(voiceName);
			ap = new AudioPlayer();
			
		}
		catch (MaryConfigurationException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void say(String input) {
		try {
			ap = new AudioPlayer();
			AudioInputStream audio = marytts.generateAudio(input);
			ap.setAudio(audio);
			ap.start();
			ap.join();

		}
		catch (Exception ex) {
			System.err.println("Error saying phrase.");
		}
		
	}

}
