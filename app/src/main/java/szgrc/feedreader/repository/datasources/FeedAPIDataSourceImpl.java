package szgrc.feedreader.repository.datasources;

import com.mobandme.android.transformer.Transformer;

import java.util.ArrayList;
import java.util.List;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class FeedAPIDataSourceImpl implements FeedAPIDataSource {
    private FeedAPIService apiService;
    private static final Transformer transformer = new Transformer.Builder().build(Feed.class);

    public FeedAPIDataSourceImpl(FeedAPIService apiService) {
        this.apiService = apiService;
    }

    @Override public List<Feed> obtainContacts() {
        try {
            APIFeedResponse apiFeedResponse = apiService.obtainFeeds();
            List<APIFeedResult> results = apiFeedResponse.getResults();
            List<Feed> contacts = new ArrayList<>();
            if (results != null) {
                for (APIFeedResult apiContact : results) {
                    contacts.add(apiContact.getUser());
                }
            }
            return contacts;
        } catch (Throwable e) {
        }
        return null;
    }
}
