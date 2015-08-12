package szgrc.feedreader.domain.feed;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public class FeedCollection implements Iterable<Feed>, Serializable {
    private final Set<Feed> feeds;

    public FeedCollection() {
        this.feeds = new LinkedHashSet<Feed>();
    }

    public Collection<Feed> getFeeds() {
        return (Collection<Feed>) ((LinkedHashSet<Feed>) feeds).clone();
    }

    public void add(Feed feed) {
        this.feeds.add(feed);
    }

    @Override public Iterator<Feed> iterator() {
        return feeds.iterator();
    }
}
