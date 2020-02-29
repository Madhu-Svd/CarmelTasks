package Model;

public class CommunityLandingModel {
    private String notificationBar;
    private String title;
    private String description;

    public CommunityLandingModel(String notificationBar, String title, String description) {
        this.notificationBar = notificationBar;
        this.title = title;
        this.description = description;
    }

    public String getNotificationBar() {
        return notificationBar;
    }

    public void setNotificationBar(String notificationBar) {
        this.notificationBar = notificationBar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
