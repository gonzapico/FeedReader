package szgrc.feedreader.repository.datasources;

import java.util.List;

import szgrc.feedreader.domain.feed.Feed;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public interface FeedAPIDataSource {

    public List<Feed> obtainContacts();
}
