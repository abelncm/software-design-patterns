package behavioral_patterns.memento;

/**
 * Memento Class: Stores the internal state of the Originator (TextEditor) object.
 * The Memento's constructor and getState() method are often package-private or
 * the Memento is an inner class of the Originator to protect encapsulation,
 * ensuring only the Originator can access the state.
 */
public class EditorMemento {
    // The state to be saved. Could be any complex object or multiple fields.
    private final String content;
    private final String fontName;
    private final int fontSize;

    /**
     * Constructor for EditorMemento.
     * It's often package-private so only the Originator (in the same package) can create it.
     * @param content The text content to save.
     * @param fontName The font name to save.
     * @param fontSize The font size to save.
     */
    EditorMemento(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
        System.out.println("EditorMemento: Saved state -> Content: \"" + content.substring(0, Math.min(content.length(), 20)) + "...\", Font: " + fontName + ", Size: " + fontSize);
    }

    /**
     * Gets the saved text content.
     * Package-private to allow only the Originator to retrieve it.
     * @return The saved content.
     */
    String getContent() {
        return content;
    }

    /**
     * Gets the saved font name.
     * @return The saved font name.
     */
    String getFontName() {
        return fontName;
    }

    /**
     * Gets the saved font size.
     * @return The saved font size.
     */
    int getFontSize() {
        return fontSize;
    }

    @Override
    public String toString() {
        // Useful for debugging the Caretaker's history
        return "EditorMemento [Content Snapshot: \"" + content.substring(0, Math.min(content.length(), 20)) +
               (content.length() > 20 ? "..." : "") +
               "\", Font: " + fontName + ", Size: " + fontSize + "]";
    }
}
