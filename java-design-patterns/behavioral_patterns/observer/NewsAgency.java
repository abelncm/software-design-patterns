package behavioral_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject Class: Implements the NewsSubject interface.
 * It maintains a list of NewsObserver objects and notifies them when its state changes
 * (e.g., when new news is published).
 */
public class NewsAgency implements NewsSubject {
    private String agencyName;
    private List<NewsObserver> observers;
    private String latestHeadline;
    private String latestContent;

    public NewsAgency(String agencyName) {
        if (agencyName == null || agencyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Agency name cannot be null or empty.");
        }
        this.agencyName = agencyName;
        this.observers = new ArrayList<>();
        System.out.println("NewsAgency '" + agencyName + "' created.");
    }

    @Override
    public void registerObserver(NewsObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            System.out.println("NewsAgency '" + agencyName + "': Observer '" + observer.getClass().getSimpleName() + "' registered.");
        }
    }

    @Override
    public void removeObserver(NewsObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("NewsAgency '" + agencyName + "': Observer '" + observer.getClass().getSimpleName() + "' removed.");
        }
    }

    @Override
    public void notifyObservers() {
        if (latestHeadline == null || latestContent == null) {
            System.out.println("NewsAgency '" + agencyName + "': No news to notify about.");
            return;
        }
        System.out.println("NewsAgency '" + agencyName + "' is notifying " + observers.size() + " observers about new headline: '" + latestHeadline + "'");
        // Create a copy of the list to iterate over if observers might unregister themselves during update
        // List<NewsObserver> observersCopy = new ArrayList<>(observers);
        // For this example, direct iteration is fine.
        for (NewsObserver observer : observers) {
            observer.update(this.agencyName, this.latestHeadline, this.latestContent);
        }
    }

    /**
     * Publishes new news. This changes the state of the NewsAgency
     * and should trigger a notification to observers.
     * @param headline The headline of the news.
     * @param content The content of the news.
     */
    public void publishNews(String headline, String content) {
        System.out.println("\nNewsAgency '" + agencyName + "' is publishing new news...");
        this.latestHeadline = headline;
        this.latestContent = content;
        System.out.println("Headline: '" + headline + "'");
        System.out.println("Content: \"" + content.substring(0, Math.min(content.length(), 50)) + (content.length() > 50 ? "..." : "") + "\"");
        notifyObservers(); // Notify all registered observers
    }

    public String getAgencyName() {
        return agencyName;
    }
}
