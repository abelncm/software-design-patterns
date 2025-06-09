package structural_patterns.adapter;

/**
 * Target Interface: This is the interface the client code expects to use.
 */
public interface MediaPlayer {
    /**
     * Plays an audio file of a given type.
     * @param audioType The type of audio (e.g., "mp3", "vlc", "mp4").
     * @param fileName The name of the file to play.
     */
    void play(String audioType, String fileName);
}
