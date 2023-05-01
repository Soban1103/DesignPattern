package Structural;

interface MediaPlayer {
	public void play(String type, String fileName);
}

class AdvancedMediaPlayer {
    // Adaptee

	public void playVlc(String fileName) {
		System.out.println("Playing vlc type " + fileName);
	}

	public void playMp4(String fileName) {
		System.out.println("Playing mp4 type " + fileName);
	}

	public void playMp3(String fileName) {
		System.out.println("Playing mp3 type" + fileName);
	}

	public void playAvi(String fileName) {
		System.out.println("Playing avi type" + fileName);
	}
}

class MediaAdapter implements MediaPlayer {
    // Adapter

	AdvancedMediaPlayer adv = new AdvancedMediaPlayer();

	public void play(String type, String fileName) {
		if (type.equalsIgnoreCase("vlc"))
			adv.playVlc(fileName);
		else if (type.equalsIgnoreCase("mp3"))
			adv.playMp3(fileName);
		else if (type.equalsIgnoreCase("mp4"))
			adv.playMp4(fileName);
	}
}

class AudioPlayer implements MediaPlayer {
    // Target interface which client is accessing
	// Client

	public void play(String type, String fileName) {
		MediaPlayer md = new MediaAdapter();
		md.play(type, fileName);
	}
}

public class AdapterD {

	public static void main(String[] args) {
		MediaPlayer m = new AudioPlayer();
		m.play("vlc", "music1.vlc");
		m.play("mp3", "music2.mp3");
		m.play("mp4", "music3.mp4");
    }
}
