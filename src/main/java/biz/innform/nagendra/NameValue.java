package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NameValue {
    private String name;
    private String value;

    public NameValue() {
    }

    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NameValue{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
