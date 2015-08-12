package szgrc.feedreader.repository.datasources;

import retrofit.http.GET;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public interface FeedAPIService {

    static final String API_VERSION = "/feeds/rss2.xml";

    @GET(API_VERSION)
    public APIFeedResponse obtainFeeds();
}
