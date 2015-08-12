package szgrc.feedreader.domain;

import java.util.List;

import szgrc.feedreader.domain.feed.Feed;
import szgrc.feedreader.executor.BaseEvent;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class GetFeedsEvent extends BaseEvent{
    private List<Feed> feeds;

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> contacts) {
        this.feeds = contacts;
    }

    public void addFeed(Feed f){
        this.feeds.add(f);
    }

}
