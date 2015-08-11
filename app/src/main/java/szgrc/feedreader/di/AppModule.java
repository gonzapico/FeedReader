package szgrc.feedreader.di;

import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import szgrc.feedreader.FeedReaderApplication;

/**
 * Dagger module with application scope.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
@Module(
        injects = {
                FeedReaderApplication.class
        }, library = true)
public final class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }
}
