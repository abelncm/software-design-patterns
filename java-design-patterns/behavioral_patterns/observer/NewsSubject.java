package behavioral_patterns.observer;

/**
 * Subject (or Observable) Interface: Declares methods for managing observers
 * (register, remove) and a method to notify observers of state changes.
 */
public interface NewsSubject {
    /**
     * Registers an observer to receive updates from this subject.
     * @param observer The NewsObserver to register.
     */
    void registerObserver(NewsObserver observer);

    /**
     * Removes an observer so it no longer receives updates.
     * @param observer The NewsObserver to remove.
     */
    void removeObserver(NewsObserver observer);

    /**
     * Notifies all registered observers of a state change.
     * This is typically called when the subject's state has changed.
     */
    void notifyObservers();
}
