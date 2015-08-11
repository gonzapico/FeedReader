package szgrc.feedreader.executor;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
class MainThreadImpl implements MainThread{
    private Handler handler;

    @Inject
    MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
