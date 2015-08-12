package szgrc.feedreader.repository.datasources;

import java.util.List;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public interface FeedBDDataSource {
    List<Feed> getFeeds();

    void persist(List<Feed> feeds);

    Feed obtain(String id);

    void delete(List<Feed> deleted);
}
