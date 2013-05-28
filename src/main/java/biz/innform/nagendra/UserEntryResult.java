package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/16/12
 * Time: 7:18 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntryResult {
    private UserEntryValue[] entry_list;

    public UserEntryValue[] getEntry_list() {
        return entry_list;
    }

    public void setEntry_list(UserEntryValue[] entry_list) {
        this.entry_list = entry_list;
    }

    @Override
    public String toString() {
        return "UserEntryResult{" +
                "entry_list=" + (entry_list == null ? null : Arrays.asList(entry_list)) +
                '}';
    }
}
