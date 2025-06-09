package structural_patterns.adapter;

/**
 * Concrete Adaptee: Implements the AdvancedMediaPlayer for MP4 format.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Mp4Player does not play vlc files directly through this method.
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
