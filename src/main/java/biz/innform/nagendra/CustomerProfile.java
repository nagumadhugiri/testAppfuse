package biz.innform.nagendra;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerProfile {
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private Address address;
    private String gender;
    private String telephone;
    private String mobile;
    private String email;
    private String crmContactId;
    private String crmAccountId;
    private String crmAccountName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrmContactId() {
        return crmContactId;
    }

    public void setCrmContactId(String crmContactId) {
        this.crmContactId = crmContactId;
    }

    public String getCrmAccountId() {
        return crmAccountId;
    }

    public void setCrmAccountId(String crmAccountId) {
        this.crmAccountId = crmAccountId;
    }

    public String getCrmAccountName() {
        return crmAccountName;
    }

    public void setCrmAccountName(String crmAccountName) {
        this.crmAccountName = crmAccountName;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "id=" + id +
                ",\n title='" + title + '\'' +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n address=" + address +
                ",\n gender='" + gender + '\'' +
                ",\n telephone='" + telephone + '\'' +
                ",\n mobile='" + mobile + '\'' +
                ",\n email='" + email + '\'' +
                ",\n crmContactId='" + crmContactId + '\'' +
                ",\n crmAccountId='" + crmAccountId + '\'' +
                ",\n crmAccountName='" + crmAccountName + '\'' +
                '}';
    }
}
