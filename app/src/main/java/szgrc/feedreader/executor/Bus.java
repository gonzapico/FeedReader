package szgrc.feedreader.executor;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public interface Bus {
    void post(Object object);

    void register(Object object);

    void unregister(Object object);
}
