package behavioral_patterns.observer;

/**
 * ConcreteObserver A: Implements the NewsObserver interface.
 * This observer represents a news channel that displays received news.
 */
public class NewsChannel implements NewsObserver {
    private String channelName;

    public NewsChannel(String channelName) {
        if (channelName == null || channelName.trim().isEmpty()) {
            throw new IllegalArgumentException("Channel name cannot be null or empty.");
        }
        this.channelName = channelName;
        System.out.println("NewsChannel '" + channelName + "' created.");
    }

    /**
     * Called by the Subject (NewsAgency) when new news is published.
     * This NewsChannel will display the news.
     * @param newsAgencyName The name of the news agency that published the news.
     * @param newsHeadline The headline of the news.
     * @param newsContent The content of the news.
     */
    @Override
    public void update(String newsAgencyName, String newsHeadline, String newsContent) {
        System.out.println("\n--- " + channelName + " (News Channel) ---");
        System.out.println("Breaking News from " + newsAgencyName + "!");
        System.out.println("Headline: " + newsHeadline);
        System.out.println("Story: " + newsContent);
        System.out.println("--- End of " + channelName + " Broadcast ---");
    }

    public String getChannelName() {
        return channelName;
    }
}
