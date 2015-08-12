package szgrc.feedreader.executor;

import android.os.Handler;
import android.os.Looper;

import de.greenrobot.event.EventBus;

/**
 * Created by gonzalofernandez on 12/08/15.
 */
public class BusImpl extends EventBus implements Bus {

    private static final Handler handler = new Handler(Looper.getMainLooper());

    @Override public void post(final Object event) {
        handler.post(new Runnable() {
            @Override public void run() {
                BusImpl.super.post(event);
            }
        });
    }
}
