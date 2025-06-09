package structural_patterns.adapter;

/**
 * Concrete Adaptee: Implements the AdvancedMediaPlayer for VLC format.
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // VlcPlayer does not play mp4 files directly through this method.
        // This method could be left empty, throw an exception, or log a message.
        // For this example, we'll assume it does nothing if called.
    }
}
