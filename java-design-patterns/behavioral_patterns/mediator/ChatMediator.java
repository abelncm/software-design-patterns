package behavioral_patterns.mediator;

/**
 * Mediator Interface: Declares methods used by Colleague objects to communicate
 * with the mediator and, indirectly, with other colleagues.
 */
public interface ChatMediator {
    /**
     * Sends a message from a user to other users in the chat (or all users).
     * @param message The message content.
     * @param sender The User object who sent the message.
     */
    void sendMessage(String message, User sender);

    /**
     * Adds a user to the chat mediator's list of managed users.
     * @param user The User to add.
     */
    void addUser(User user);

    /**
     * Removes a user from the chat mediator's list.
     * @param user The User to remove.
     */
    void removeUser(User user);
}
