package Model;

public class Contact_list {
    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;


    private int viewType;
    private String name;

    public Contact_list(String name,int viewType) {
        this.name = name;
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

}
