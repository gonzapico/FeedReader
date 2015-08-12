package szgrc.feedreader.repository.datasources;

import com.google.gson.annotations.Expose;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class APIFeedResult {

    @Expose
    private Feed feed;
    @Expose private String seed;

    public Feed getUser() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
