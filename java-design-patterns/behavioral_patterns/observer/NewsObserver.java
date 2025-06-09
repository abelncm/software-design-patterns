package behavioral_patterns.observer;

/**
 * Observer Interface: Declares an update method that the subject will call
 * when its state changes.
 * In this example, observers are interested in news updates.
 */
public interface NewsObserver {
    /**
     * Called by the Subject when its state changes.
     * Observers implement this method to react to the notification.
     *
     * @param newsHeadline The news headline or a state object from the subject.
     *                     For simplicity, we pass the headline directly.
     * @param newsContent  The detailed content of the news.
     */
    void update(String newsAgencyName, String newsHeadline, String newsContent);
}
