package behavioral_patterns.memento;

/**
 * Client Class (Demo): Uses the Originator (TextEditor) and Caretaker (EditorHistory).
 * It triggers state changes in the Originator, saves states using the Caretaker,
 * and then restores previous states (simulating undo).
 */
public class MementoDemo {
    public static void main(String[] args) {
        System.out.println("--- Memento Pattern Demo: Text Editor Undo/Redo ---");

        // 1. Create Originator (TextEditor) and Caretaker (EditorHistory)
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        // 2. Initial state - save it (optional, but good for full undo to initial)
        System.out.println("\nStep 1: Initial empty state. Saving.");
        history.addMemento(editor.saveStateToMemento());
        editor.displayState();

        // 3. User types some text
        System.out.println("\nStep 2: User types 'Hello'.");
        editor.type("Hello");
        // Save state after typing "Hello"
        history.addMemento(editor.saveStateToMemento());

        // 4. User types more text
        System.out.println("\nStep 3: User types ' World!'.");
        editor.type(" World!");
        // Save state after typing " World!"
        history.addMemento(editor.saveStateToMemento());

        // 5. User changes font
        System.out.println("\nStep 4: User changes font to 'Times New Roman', 14pt.");
        editor.setFont("Times New Roman", 14);
        // Save state after font change
        history.addMemento(editor.saveStateToMemento());

        // 6. User types " This is fun."
        System.out.println("\nStep 5: User types ' This is fun.'.");
        editor.type(" This is fun.");
        // Not saving this state immediately to show undo to previous memento.
        editor.displayState();


        // 7. Perform UNDO operations
        System.out.println("\n--- Performing Undo Operations ---");

        System.out.println("\nUndo 1 (revert ' This is fun.' typing - effectively going back to font change):");
        // Note: The " This is fun." state was not saved, so the first undo will revert the font change.
        // To correctly undo just " This is fun.", we should have saved before it.
        // Let's adjust the narrative: assume we want to undo the font change.
        // For a true "undo last action", we'd save before *every* significant action.
        // For this demo, we'll pop the last saved state which was after font change.
        // To make it logical, let's save the state after "This is fun."
        System.out.println("Correcting: Saving state after ' This is fun.' for proper undo sequence demonstration.");
        history.addMemento(editor.saveStateToMemento()); // Current state: "Hello World! This is fun.", Times New Roman, 14pt

        System.out.println("\nUndo 1 (reverting ' This is fun.'):");
        EditorMemento memento1 = history.undo(); // Removes "Hello World! This is fun." memento
        editor.restoreStateFromMemento(memento1); // Restores to "Hello World!", Times New Roman, 14pt
                                                  // (Actually restores to the state of memento1 which is "Hello World! This is fun.")
                                                  // The memento popped is the *last saved state*.
                                                  // So, this undo will restore the state with " This is fun.".
                                                  // To undo the typing of " This is fun.", we need to pop the memento *before* it.

        // Let's clarify the undo logic for the demo:
        // Current history stack top-to-bottom:
        // 4. "Hello World! This is fun." (Times, 14pt) -> memento from current line 52
        // 3. "Hello World!" (Times, 14pt)             -> memento from step 4
        // 2. "Hello World!" (Arial, 12pt)            -> memento from step 3
        // 1. "Hello" (Arial, 12pt)                   -> memento from step 2
        // 0. "" (Arial, 12pt)                        -> memento from step 1

        System.out.println("\nUndo 1 (current is 'Hello World! This is fun.', Times, 14pt):");
        editor.restoreStateFromMemento(history.undo()); // Restores to "Hello World!", Times, 14pt (State 3)
        System.out.println("Editor content after 1st undo: \"" + editor.getCurrentContent() + "\"");


        System.out.println("\nUndo 2 (current is 'Hello World!', Times, 14pt):");
        editor.restoreStateFromMemento(history.undo()); // Restores to "Hello World!", Arial, 12pt (State 2)
        System.out.println("Editor content after 2nd undo: \"" + editor.getCurrentContent() + "\"");

        System.out.println("\nUndo 3 (current is 'Hello World!', Arial, 12pt):");
        editor.restoreStateFromMemento(history.undo()); // Restores to "Hello", Arial, 12pt (State 1)
        System.out.println("Editor content after 3rd undo: \"" + editor.getCurrentContent() + "\"");

        System.out.println("\nUndo 4 (current is 'Hello', Arial, 12pt):");
        editor.restoreStateFromMemento(history.undo()); // Restores to "", Arial, 12pt (State 0 - initial)
        System.out.println("Editor content after 4th undo: \"" + editor.getCurrentContent() + "\"");

        System.out.println("\nAttempting one more undo (history should be empty):");
        EditorMemento nullMemento = history.undo(); // Should be null
        if (nullMemento == null) {
            System.out.println("No more states to undo, as expected.");
        }
        editor.displayState(); // Should still be the initial empty state

        System.out.println("\n--- Memento Pattern Demo Finished ---");
    }
}
