package behavioral_patterns.observer;

/**
 * Client Class (Demo): Creates ConcreteSubject (NewsAgency) and
 * ConcreteObserver (NewsChannel, EmailSubscriber) objects.
 * It registers observers with the subject and then changes the subject's state
 * to demonstrate that observers are notified and update themselves.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Demo: News Agency ---");

        // 1. Create the ConcreteSubject (NewsAgency)
        NewsAgency worldNewsAgency = new NewsAgency("World News Today");
        NewsAgency techNewsAgency = new NewsAgency("Tech Gizmo Weekly");

        // 2. Create ConcreteObserver objects
        NewsObserver channel1 = new NewsChannel("Global News Network (GNN)");
        NewsObserver channel2 = new NewsChannel("Local Town TV (LTTV)");
        NewsObserver subscriber1 = new EmailSubscriber("john.doe@example.com");
        NewsObserver subscriber2 = new EmailSubscriber("jane.smith@example.com");
        NewsObserver techFanSubscriber = new EmailSubscriber("techlover@example.com");

        // 3. Register observers with subjects
        System.out.println("\n--- Registering Observers ---");
        worldNewsAgency.registerObserver(channel1);         // GNN subscribes to World News
        worldNewsAgency.registerObserver(subscriber1);      // John Doe subscribes to World News

        techNewsAgency.registerObserver(channel2);          // LTTV subscribes to Tech News (maybe local tech segment)
        techNewsAgency.registerObserver(subscriber2);       // Jane Smith subscribes to Tech News
        techNewsAgency.registerObserver(techFanSubscriber); // TechLover subscribes to Tech News

        // Also, GNN wants tech news, and TechLover wants world news too
        techNewsAgency.registerObserver(channel1);          // GNN also subscribes to Tech News
        worldNewsAgency.registerObserver(techFanSubscriber);// TechLover also subscribes to World News


        // 4. Subject changes state (publishes news), observers should be notified
        System.out.println("\n--- World News Agency Publishing ---");
        worldNewsAgency.publishNews(
            "Peace Treaty Signed!",
            "A historic peace treaty has been signed today between Nation A and Nation B, ending decades of conflict. " +
            "Celebrations are underway across the globe."
        );
        // Expected: channel1, subscriber1, techFanSubscriber get this news.

        System.out.println("\n--- Tech Gizmo Weekly Publishing ---");
        techNewsAgency.publishNews(
            "New Quantum CPU Announced",
            "Innovatech Corp today unveiled its new 'QuantumLeap' CPU, promising speeds 1000x faster than current " +
            "generation processors. The tech world is buzzing with excitement."
        );
        // Expected: channel2, subscriber2, techFanSubscriber, channel1 get this news.

        // 5. Unregister an observer and publish again
        System.out.println("\n--- Unregistering GNN (channel1) from World News Agency ---");
        worldNewsAgency.removeObserver(channel1);

        System.out.println("\n--- World News Agency Publishing Again ---");
        worldNewsAgency.publishNews(
            "Market Hits Record High",
            "The stock market reached an all-time high today following positive economic indicators and the recent peace treaty."
        );
        // Expected: subscriber1, techFanSubscriber get this news. channel1 (GNN) should NOT.

        System.out.println("\n--- Observer Pattern Demo Finished ---");
    }
}
