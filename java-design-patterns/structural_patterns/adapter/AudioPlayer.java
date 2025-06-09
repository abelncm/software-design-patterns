package structural_patterns.adapter;

/**
 * Client Class: Uses the MediaPlayer (Target) interface to play audio files.
 * It can play "mp3" files directly and uses MediaAdapter for other formats.
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter; // Holds a reference to the adapter

    /**
     * Plays an audio file. If the format is "mp3", it plays directly.
     * For "vlc" or "mp4", it uses the MediaAdapter.
     * Other formats are considered invalid.
     * @param audioType The type of audio (e.g., "mp3", "vlc", "mp4").
     * @param fileName The name of the file to play.
     */
    @Override
    public void play(String audioType, String fileName) {
        // Inbuilt support to play mp3 music files
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("AudioPlayer: Playing MP3 file: " + fileName);
        }
        // mediaAdapter is providing support to play other file formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            // We create a new adapter instance for the specific type.
            // In a more complex scenario, an adapter instance might be managed or injected.
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("AudioPlayer: Invalid media type '" + audioType + "'. Format not supported for file " + fileName);
        }
    }
}
