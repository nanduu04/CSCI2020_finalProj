package application;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.media.AudioClip;


public class Sound {

	
	private static HashMap<String, ArrayList<AudioClip>> library = new HashMap<String, ArrayList<AudioClip>>();
	
	 //Add a new audio clip to the sound library.
	
	public static void addSound(String key, AudioClip value) {
		if (!library.containsKey(key)) library.put(key, new ArrayList<AudioClip>());
		library.get(key).add(value);
	}

	
	 //Play the sound linked with given key. If multiple sounds reside on same
	 //key a random from the group will be played.
	 
	public static void playSound(String key) {
		if (!library.containsKey(key)) return;

		ArrayList<AudioClip> sounds = library.get(key);
		sounds.get((int) (Math.random() * sounds.size())).play();
	}
}