package behavioral_patterns.memento;

/**
 * Originator Class: The object whose state needs to be saved and restored.
 * It creates Memento objects containing snapshots of its internal state and
 * uses Mementos to restore its state.
 */
public class TextEditor {
    private StringBuilder content; // Using StringBuilder for mutable text content
    private String fontName;
    private int fontSize;

    public TextEditor() {
        this.content = new StringBuilder();
        this.fontName = "Arial";
        this.fontSize = 12;
        System.out.println("TextEditor: Initialized. Content: \"\", Font: " + fontName + ", Size: " + fontSize);
    }

    public void type(String text) {
        this.content.append(text);
        System.out.println("TextEditor: Typed -> \"" + text + "\"");
        displayState();
    }

    public void delete(int charactersToRemove) {
        if (content.length() >= charactersToRemove) {
            content.delete(content.length() - charactersToRemove, content.length());
            System.out.println("TextEditor: Deleted " + charactersToRemove + " characters.");
        } else {
            content.setLength(0);
            System.out.println("TextEditor: Deleted all content (less than " + charactersToRemove + " chars existed).");
        }
        displayState();
    }

    public void setFont(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        System.out.println("TextEditor: Font changed to " + fontName + ", " + fontSize + "pt.");
        displayState();
    }

    /**
     * Creates a Memento containing a snapshot of the editor's current state.
     * @return A new EditorMemento object.
     */
    public EditorMemento saveStateToMemento() {
        System.out.println("TextEditor: Saving current state to Memento.");
        // Pass current state to Memento constructor
        return new EditorMemento(this.content.toString(), this.fontName, this.fontSize);
    }

    /**
     * Restores the editor's state from a Memento object.
     * @param memento The EditorMemento object to restore from.
     */
    public void restoreStateFromMemento(EditorMemento memento) {
        if (memento != null) {
            // Assuming Memento's getters are accessible (e.g., package-private or Memento is inner class)
            this.content = new StringBuilder(memento.getContent());
            this.fontName = memento.getFontName();
            this.fontSize = memento.getFontSize();
            System.out.println("TextEditor: State restored from Memento.");
            displayState();
        } else {
            System.out.println("TextEditor: Null memento provided, state not restored.");
        }
    }

    public void displayState() {
        System.out.println("TextEditor Current State -> Content: \"" + content.toString() +
                           "\", Font: " + fontName + ", Size: " + fontSize + "pt");
    }

    // Getter for current content, mainly for assertions or direct checks in demo
    public String getCurrentContent() {
        return content.toString();
    }
}
