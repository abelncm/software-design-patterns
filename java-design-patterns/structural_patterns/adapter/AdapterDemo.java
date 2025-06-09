package structural_patterns.adapter;

/**
 * Demo Class: To demonstrate the use of the Adapter pattern.
 */
public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Demo ---");

        // Create an AudioPlayer instance (Client)
        AudioPlayer audioPlayer = new AudioPlayer();

        // AudioPlayer can play mp3 files directly
        System.out.println("\nTesting direct play for MP3:");
        audioPlayer.play("mp3", "beyond_the_horizon.mp3");

        // AudioPlayer uses MediaAdapter to play other formats like vlc and mp4
        System.out.println("\nTesting adapter for VLC:");
        audioPlayer.play("vlc", "far_far_away.vlc");

        System.out.println("\nTesting adapter for MP4:");
        audioPlayer.play("mp4", "mind_blown.mp4");

        // Testing an unsupported format
        System.out.println("\nTesting unsupported format (AVI):");
        audioPlayer.play("avi", "some_movie.avi");

        System.out.println("\n--- Testing MediaAdapter directly (for understanding) ---");
        // This part is just to show how MediaAdapter works internally,
        // normally the client (AudioPlayer) would be used.
        MediaPlayer vlcAdapter = new MediaAdapter("vlc");
        vlcAdapter.play("vlc", "another_song.vlc");
        // Attempting to play a different format with an adapter initialized for "vlc"
        // The current MediaAdapter's play method checks audioType again.
        vlcAdapter.play("mp4", "should_not_be_played_by_vlc_player_via_this_adapter_instance.mp4");


        MediaPlayer mp4Adapter = new MediaAdapter("mp4");
        mp4Adapter.play("mp4", "yet_another_video.mp4");
        mp4Adapter.play("vlc", "should_not_be_played_by_mp4_player_via_this_adapter_instance.vlc");

        // Adapter initialized with an invalid type (as per MediaAdapter constructor logic)
        System.out.println("\nTesting adapter initialized with invalid type:");
        MediaPlayer invalidAdapter = new MediaAdapter("avi"); // Constructor logs an issue
        invalidAdapter.play("avi", "test.avi"); // play() method logs an issue

        System.out.println("\n--- Adapter Pattern Demo Finished ---");
    }
}
