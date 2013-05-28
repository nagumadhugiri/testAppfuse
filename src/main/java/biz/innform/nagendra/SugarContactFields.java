package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SugarContactFields {
    private NameValue id;
    private NameValue first_name;
    private NameValue last_name;
    private NameValue email1;
    private NameValue primary_address_street;
    private NameValue primary_address_city;
    private NameValue primary_address_state;
    private NameValue primary_address_postalcode;
    private NameValue primary_address_country;
    private NameValue phone_work;
    private NameValue phone_mobile;
    private NameValue salutation;
    private NameValue account_name;
    private NameValue account_id;
    private NameValue assigned_user_name;
    private NameValue assigned_user_id;

    public NameValue getId() {
        return id;
    }

    public void setId(NameValue id) {
        this.id = id;
    }

    public NameValue getFirst_name() {
        return first_name;
    }

    public void setFirst_name(NameValue first_name) {
        this.first_name = first_name;
    }

    public NameValue getLast_name() {
        return last_name;
    }

    public void setLast_name(NameValue last_name) {
        this.last_name = last_name;
    }

    public NameValue getEmail1() {
        return email1;
    }

    public void setEmail1(NameValue email1) {
        this.email1 = email1;
    }

    public NameValue getPrimary_address_street() {
        return primary_address_street;
    }

    public void setPrimary_address_street(NameValue primary_address_street) {
        this.primary_address_street = primary_address_street;
    }

    public NameValue getPrimary_address_city() {
        return primary_address_city;
    }

    public void setPrimary_address_city(NameValue primary_address_city) {
        this.primary_address_city = primary_address_city;
    }

    public NameValue getPrimary_address_state() {
        return primary_address_state;
    }

    public void setPrimary_address_state(NameValue primary_address_state) {
        this.primary_address_state = primary_address_state;
    }

    public NameValue getPrimary_address_postalcode() {
        return primary_address_postalcode;
    }

    public void setPrimary_address_postalcode(NameValue primary_address_postalcode) {
        this.primary_address_postalcode = primary_address_postalcode;
    }

    public NameValue getPrimary_address_country() {
        return primary_address_country;
    }

    public void setPrimary_address_country(NameValue primary_address_country) {
        this.primary_address_country = primary_address_country;
    }

    public NameValue getPhone_work() {
        return phone_work;
    }

    public void setPhone_work(NameValue phone_work) {
        this.phone_work = phone_work;
    }

    public NameValue getPhone_mobile() {
        return phone_mobile;
    }

    public void setPhone_mobile(NameValue phone_mobile) {
        this.phone_mobile = phone_mobile;
    }

    public NameValue getSalutation() {
        return salutation;
    }

    public void setSalutation(NameValue salutation) {
        this.salutation = salutation;
    }

    public NameValue getAccount_name() {
        return account_name;
    }

    public void setAccount_name(NameValue account_name) {
        this.account_name = account_name;
    }

    public NameValue getAccount_id() {
        return account_id;
    }

    public void setAccount_id(NameValue account_id) {
        this.account_id = account_id;
    }

    public NameValue getAssigned_user_name() {
        return assigned_user_name;
    }

    public void setAssigned_user_name(NameValue assigned_user_name) {
        this.assigned_user_name = assigned_user_name;
    }

    public NameValue getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(NameValue assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

    @Override
    public String toString() {
        return "SugarContactFields{" +
                "id=" + id +
                ", first_name=" + first_name +
                ", last_name=" + last_name +
                ", email1=" + email1 +
                ", primary_address_street=" + primary_address_street +
                ", primary_address_city=" + primary_address_city +
                ", primary_address_state=" + primary_address_state +
                ", primary_address_postalcode=" + primary_address_postalcode +
                ", primary_address_country=" + primary_address_country +
                ", phone_work=" + phone_work +
                ", phone_mobile=" + phone_mobile +
                ", salutation=" + salutation +
                ", account_name=" + account_name +
                ", account_id=" + account_id +
                ", assigned_user_name=" + assigned_user_name +
                ", assigned_user_id=" + assigned_user_id +
                '}';
    }
}
