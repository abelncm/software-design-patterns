package structural_patterns.adapter;

/**
 * Adaptee Interface: Defines the interface for advanced media players
 * that have specific methods for their formats. This is the interface
 * that is incompatible with the MediaPlayer (Target) interface.
 */
public interface AdvancedMediaPlayer {
    /**
     * Plays a VLC media file.
     * @param fileName The name of the VLC file.
     */
    void playVlc(String fileName);

    /**
     * Plays an MP4 media file.
     * @param fileName The name of the MP4 file.
     */
    void playMp4(String fileName);
}
