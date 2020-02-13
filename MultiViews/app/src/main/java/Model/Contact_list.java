package Model;

public class Contact_list {
    public static final int TEXT_TYPE = 0;
    public static final int IMAGE_TYPE = 0;

    private int viewType;
    private String name;
    private String number;

    public Contact_list(int viewType, String name, String number) {
        this.viewType = viewType;
        this.name = name;
        this.number = number;
    }

    public int getViewType() {
        return viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }




}
