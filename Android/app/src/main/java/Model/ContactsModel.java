package Model;

public class ContactsModel {
    private String _id;
    private String dn;
    private String mobile;
    private String mail;
    private String name ;
    private String company ;
    private String department;
    private String title ;
    private int __v ;
    private String updated_at;

    public ContactsModel() {

    }

    public ContactsModel(String mobile, String mail,
                           String name, String company,
                           String department, String title) {

        this.mobile = mobile;
        this.mail = mail;
        this.name = name;
        this.company = company;
        this.department = department;
        this.title = title;
    }

    public String get_id() {
        return _id;
    }

    public String getDn() {
        return dn;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public int get__v() {
        return __v;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
