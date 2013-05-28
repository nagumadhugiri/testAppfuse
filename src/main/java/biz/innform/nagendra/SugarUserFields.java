package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/16/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SugarUserFields {
    NameValue id;
    NameValue user_name;

    public NameValue getId() {
        return id;
    }

    public void setId(NameValue id) {
        this.id = id;
    }

    public NameValue getUser_name() {
        return user_name;
    }

    public void setUser_name(NameValue user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "SugarUserFields{" +
                "id=" + id +
                ", user_name=" + user_name +
                '}';
    }
}
