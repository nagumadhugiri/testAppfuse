package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryValue {
    private String id;
    private String module_name;
    private SugarContactFields name_value_list;

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

    public SugarContactFields getName_value_list() {
        return name_value_list;
    }

    public void setName_value_list(SugarContactFields name_value_list) {
        this.name_value_list = name_value_list;
    }

    @Override
    public String toString() {
        return "EntryValue{" +
                "id='" + id + '\'' +
                ", module_name='" + module_name + '\'' +
                ", name_value_list=" + name_value_list +
                '}';
    }
}
