package behavioral_patterns.mediator;

/**
 * Colleague Abstract Class: Each colleague object knows its mediator.
 * It has a reference to the Mediator and uses it to communicate with
 * other colleagues instead of direct communication.
 */
public abstract class User {
    protected ChatMediator mediator;
    protected String name;
    protected String id; // Unique identifier for the user

    public User(ChatMediator mediator, String id, String name) {
        if (mediator == null) {
            throw new IllegalArgumentException("ChatMediator cannot be null.");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty.");
        }
        this.mediator = mediator;
        this.id = id;
        this.name = name;
        System.out.println("User '" + name + "' (ID: " + id + ") created and associated with mediator " + mediator.getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    /**
     * Sends a message via the mediator.
     * @param message The message content.
     */
    public abstract void send(String message);

    /**
     * Receives a message from the mediator.
     * @param message The message content.
     * @param senderName The name of the user who sent the message.
     */
    public abstract void receive(String message, String senderName);

    // It's good practice for colleagues to be comparable, e.g., by ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
