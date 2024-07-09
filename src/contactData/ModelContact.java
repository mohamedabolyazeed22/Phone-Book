package contactData;


import javax.swing.Icon;

public class ModelContact {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getjobTitle() {
        return jobTitle;
    }

    public void setjobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ModelContact(Icon icon, String name, String jobTitle, String PhoneNumber, String email) {
        this.icon = icon;
        this.name = name;
        this.jobTitle = jobTitle;
        this.PhoneNumber = PhoneNumber;
        this.email = email;
    }

    public ModelContact() {
    }

    private Icon icon;
    private String name;
    private String jobTitle;
    private String PhoneNumber;
    private String email;

    public Object[] toRowTable() {
        return new Object[]{new ModelProfile(icon, name), jobTitle, PhoneNumber, email};
    }
}
