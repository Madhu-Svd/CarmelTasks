package Model;

public class MyTicketsModel {
   private String ticketsStatus;
    private int ticketsDate;
    private String ticketsName;
    private String ticketsNo;
    private int ticketsValue;
    private String clock;
    private int ticketsTime;
    private int notificationIcon;

    public String getTicketsStatus() {
        return ticketsStatus;
    }

    public void setTicketsStatus(String ticketsStatus) {
        this.ticketsStatus = ticketsStatus;
    }

    public int getTicketsDate() {
        return ticketsDate;
    }

    public void setTicketsDate(int ticketsDate) {
        this.ticketsDate = ticketsDate;
    }

    public String getTicketsName() {
        return ticketsName;
    }

    public void setTicketsName(String ticketsName) {
        this.ticketsName = ticketsName;
    }

    public String getTicketsNo() {
        return ticketsNo;
    }

    public void setTicketsNo(String ticketsNo) {
        this.ticketsNo = ticketsNo;
    }

    public int getTicketsValue() {
        return ticketsValue;
    }

    public void setTicketsValue(int ticketsValue) {
        this.ticketsValue = ticketsValue;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public int getTicketsTime() {
        return ticketsTime;
    }

    public void setTicketsTime(int ticketsTime) {
        this.ticketsTime = ticketsTime;
    }

    public int getNotificationIcon() {
        return notificationIcon;
    }

    public void setNotificationIcon(int notificationIcon) {
        this.notificationIcon = notificationIcon;
    }
}
