package behavioral_patterns.mediator;

/**
 * Client Class (Demo): Creates the ConcreteMediator (ChatRoomMediatorImpl)
 * and several ConcreteColleague (ChatUser) objects.
 * It registers the colleagues with the mediator and then triggers actions
 * from some colleagues to show how they communicate indirectly via the mediator.
 */
public class MediatorDemo {
    public static void main(String[] args) {
        System.out.println("--- Mediator Pattern Demo: Chat Room ---");

        // 1. Create the ConcreteMediator (the chat room)
        ChatMediator chatRoom = new ChatRoomMediatorImpl();

        // 2. Create ConcreteColleague objects (chat users)
        // Users are associated with the mediator upon creation.
        User user1 = new ChatUser(chatRoom, "user123", "Alice");
        User user2 = new ChatUser(chatRoom, "user456", "Bob");
        User user3 = new ChatUser(chatRoom, "user789", "Charlie");
        User user4 = new ChatUser(chatRoom, "user000", "David"); // David won't be added initially

        // 3. Register users with the mediator
        System.out.println("\n--- Registering users with the Chat Room ---");
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        // user4 is intentionally not added yet to show messages are only sent to added users

        // 4. Users send messages through the mediator
        System.out.println("\n--- Users start sending messages ---");
        user1.send("Hi everyone! How are you doing?");

        System.out.println("\n--- Bob's turn ---");
        user2.send("Hello Alice! I'm doing well, thanks for asking.");

        System.out.println("\n--- Charlie's turn ---");
        user3.send("Hey Bob and Alice! Good to be here.");

        System.out.println("\n--- Adding David to the chat ---");
        chatRoom.addUser(user4);
        user4.send("Hi all, David here!"); // Now David's message should go to Alice, Bob, Charlie

        System.out.println("\n--- Alice sends another message ---");
        user1.send("Welcome David!");

        System.out.println("\n--- Removing Bob from the chat ---");
        chatRoom.removeUser(user2);

        System.out.println("\n--- Alice sends a message after Bob left ---");
        user1.send("Did Bob leave? Hope he's okay.");
        // This message should not be received by Bob.

        System.out.println("\n--- Mediator Pattern Demo Finished ---");
    }
}
