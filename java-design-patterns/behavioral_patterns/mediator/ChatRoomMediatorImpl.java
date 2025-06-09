package behavioral_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteMediator Class: Implements the ChatMediator interface and
 * coordinates communication between User (Colleague) objects.
 * It maintains a list of users in the chat room.
 */
public class ChatRoomMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatRoomMediatorImpl() {
        this.users = new ArrayList<>();
        System.out.println("ChatRoomMediatorImpl: Chat room created.");
    }

    /**
     * Adds a user to the chat room.
     * The user is also informed (implicitly by constructor or explicitly) about this mediator.
     * @param user The User to add.
     */
    @Override
    public void addUser(User user) {
        if (user != null && !this.users.contains(user)) {
            this.users.add(user);
            System.out.println("ChatRoomMediatorImpl: User '" + user.getName() + "' (ID: " + user.getId() + ") added to the chat room.");
            // Optionally, notify other users that a new user has joined.
            // sendMessage(user.getName() + " has joined the chat.", user); // Example notification
        } else if (user != null && this.users.contains(user)) {
            System.out.println("ChatRoomMediatorImpl: User '" + user.getName() + "' (ID: " + user.getId() + ") is already in the chat room.");
        }
    }

    /**
     * Removes a user from the chat room.
     * @param user The User to remove.
     */
    @Override
    public void removeUser(User user) {
        if (user != null && this.users.remove(user)) {
            System.out.println("ChatRoomMediatorImpl: User '" + user.getName() + "' (ID: " + user.getId() + ") removed from the chat room.");
            // Optionally, notify other users that a user has left.
            // sendMessage(user.getName() + " has left the chat.", user); // Example notification
        } else {
            System.out.println("ChatRoomMediatorImpl: User '" + user.getName() + "' (ID: " + user.getId() + ") not found or could not be removed.");
        }
    }

    /**
     * Sends a message from a sender to all other users in the chat room.
     * The sender itself does not receive its own message back through this broadcast.
     * @param message The message content.
     * @param sender The User who sent the message.
     */
    @Override
    public void sendMessage(String message, User sender) {
        if (sender == null || !users.contains(sender)) {
            System.out.println("ChatRoomMediatorImpl: Message from unknown or unregistered sender '" +
                               (sender != null ? sender.getName() : "null") + "' cannot be sent.");
            return;
        }

        System.out.println("ChatRoomMediatorImpl: Broadcasting message from '" + sender.getName() + "': '" + message + "'");
        for (User user : this.users) {
            // Ensure the sender does not receive their own message back via this broadcast
            if (!user.getId().equals(sender.getId())) {
                user.receive(message, sender.getName());
            }
        }
    }
}
