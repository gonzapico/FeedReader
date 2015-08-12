package szgrc.feedreader.executor;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
