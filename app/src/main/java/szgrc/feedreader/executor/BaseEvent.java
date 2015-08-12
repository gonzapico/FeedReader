package szgrc.feedreader.executor;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class BaseEvent {

    private Throwable error;

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}

