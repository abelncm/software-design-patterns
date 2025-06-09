package behavioral_patterns.observer;

/**
 * ConcreteObserver B: Implements the NewsObserver interface.
 * This observer represents an email subscriber who receives news via email.
 */
public class EmailSubscriber implements NewsObserver {
    private String subscriberEmail;

    public EmailSubscriber(String email) {
        if (email == null || !email.contains("@")) { // Basic email validation
            throw new IllegalArgumentException("Invalid email address provided for subscriber.");
        }
        this.subscriberEmail = email;
        System.out.println("EmailSubscriber created for email: " + email);
    }

    /**
     * Called by the Subject (NewsAgency) when new news is published.
     * This EmailSubscriber will simulate sending an email with the news.
     * @param newsAgencyName The name of the news agency that published the news.
     * @param newsHeadline The headline of the news.
     * @param newsContent The content of the news.
     */
    @Override
    public void update(String newsAgencyName, String newsHeadline, String newsContent) {
        System.out.println("\n--- Emailing News to " + subscriberEmail + " ---");
        System.out.println("From: " + newsAgencyName + " News Service <noreply@" + newsAgencyName.toLowerCase().replaceAll("\\s+", "") + ".com>");
        System.out.println("To: " + subscriberEmail);
        System.out.println("Subject: Breaking News: " + newsHeadline);
        System.out.println("\nDear Subscriber,\n");
        System.out.println(newsContent);
        System.out.println("\nThank you for subscribing to " + newsAgencyName + " updates.");
        System.out.println("--- Email Sent ---");
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }
}
