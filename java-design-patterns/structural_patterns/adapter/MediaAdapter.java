package structural_patterns.adapter;

/**
 * Adapter Class: Implements the MediaPlayer (Target) interface and
 * adapts an AdvancedMediaPlayer (Adaptee) instance.
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    /**
     * Constructor that takes an audio type to initialize the appropriate adaptee.
     * @param audioType The type of audio (e.g., "vlc" or "mp4") this adapter will handle.
     */
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        } else {
            // Optionally handle unsupported types, though the client (AudioPlayer)
            // should ideally only use this adapter for "vlc" or "mp4".
            advancedMusicPlayer = null;
            System.out.println("MediaAdapter: Invalid audio type '" + audioType + "' for advanced player initialization.");
        }
    }

    /**
     * Implements the play method from the MediaPlayer interface.
     * It translates the call to the appropriate method of the adaptee.
     * @param audioType The type of audio (e.g., "vlc", "mp4").
     * @param fileName The name of the file to play.
     */
    @Override
    public void play(String audioType, String fileName) {
        if (advancedMusicPlayer == null) {
            System.out.println("MediaAdapter: No advanced player initialized. Cannot play " + fileName);
            return;
        }

        // Check if the requested audioType matches the type this adapter instance is for.
        // This makes the adapter instance specific to the type it was constructed for.
        if (advancedMusicPlayer instanceof VlcPlayer && audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (advancedMusicPlayer instanceof Mp4Player && audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        } else {
            System.out.println("MediaAdapter: This adapter instance for " +
                               (advancedMusicPlayer instanceof VlcPlayer ? "VLC" : "MP4") +
                               " cannot play audio type '" + audioType + "' for file " + fileName);
        }
    }
}
