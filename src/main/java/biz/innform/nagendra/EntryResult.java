package biz.innform.nagendra;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 4/12/12
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryResult {
    private EntryValue[] entry_list;

    public EntryValue[] getEntry_list() {
        return entry_list;
    }

    public void setEntry_list(EntryValue[] entry_list) {
        this.entry_list = entry_list;
    }

    @Override
    public String toString() {
        return "EntryResult{" +
                "entry_list=" + (entry_list == null ? null : Arrays.asList(entry_list)) +
                '}';
    }
}
