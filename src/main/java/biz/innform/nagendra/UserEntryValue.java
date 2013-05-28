package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/16/12
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntryValue {
    private String id;
    private String module_name;
    private SugarUserFields name_value_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public SugarUserFields getName_value_list() {
        return name_value_list;
    }

    public void setName_value_list(SugarUserFields name_value_list) {
        this.name_value_list = name_value_list;
    }

    @Override
    public String toString() {
        return "UserEntryValue{" +
                "id='" + id + '\n' +
                ", module_name='" + module_name + '\n' +
                ", name_value_list=" + name_value_list +
                '}';
    }
}
