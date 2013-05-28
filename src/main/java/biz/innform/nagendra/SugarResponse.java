package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SugarResponse {
    String id;
    String module_name;

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

    @Override
    public String toString() {
        return "SugarLogin{" +
                "id='" + id + '\'' +
                ", module_name='" + module_name + '\'' +
                '}';
    }
}
