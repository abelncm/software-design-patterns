package behavioral_patterns.mediator;

/**
 * ConcreteColleague Class: Implements the Colleague interface/abstract class (User).
 * ChatUsers communicate with the ChatMediator when they need to interact
 * with other users (e.g., send a message) or when they receive a message.
 */
public class ChatUser extends User {

    public ChatUser(ChatMediator mediator, String id, String name) {
        super(mediator, id, name);
    }

    /**
     * Sends a message. The user tells the mediator to send the message,
     * and the mediator handles dispatching it to other users.
     * @param message The message content.
     */
    @Override
    public void send(String message) {
        System.out.println(this.name + " (ID: " + this.id + ") is sending message: '" + message + "'");
        mediator.sendMessage(message, this);
    }

    /**
     * Receives a message from another user via the mediator.
     * @param message The message content.
     * @param senderName The name of the user who sent the message.
     */
    @Override
    public void receive(String message, String senderName) {
        System.out.println(this.name + " (ID: " + this.id + ") received message from " + senderName + ": '" + message + "'");
    }
}
