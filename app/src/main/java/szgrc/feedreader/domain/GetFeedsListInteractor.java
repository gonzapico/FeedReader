package szgrc.feedreader.domain;

import szgrc.feedreader.executor.Bus;
import szgrc.feedreader.executor.Executor;
import szgrc.feedreader.executor.Interactor;
import szgrc.feedreader.executor.MainThread;
import szgrc.feedreader.repository.FeedRepository;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public class GetFeedsListInteractor implements Interactor {

    private Bus bus;
    private FeedRepository repository;
    private String id;
    private final Executor executor;
    private final MainThread mainThread;

    public GetFeedsListInteractor(Bus bus, FeedRepository repository, Executor executor, MainThread mainThread) {
        this.bus = bus;
        this.repository = repository;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    public void setData(String id) {
        this.id = id;
    }

    @Override public void execute() {
        this.executor.run(this);
    }

    @Override public void run() {
        GetFeedsEvent event = new GetFeedsEvent();
        try {
            event.setFeeds(repository.obtainContacts());
        } catch (Exception e) {
            event.setError(e);
        }
        bus.post(event);
    }
}
