package szgrc.feedreader.repository.datasources;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class APIFeedResponse {

    @Expose
    private List<APIFeedResult> results = new ArrayList<>();

    public List<APIFeedResult> getResults() {
        return results;
    }

    public void setResults(List<APIFeedResult> results) {
        this.results = results;
    }
}
