package szgrc.feedreader;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;
import szgrc.feedreader.di.AppModule;

/**
 * Dagger module to control the activity lifecycle.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public class FeedReaderApplication extends Application{

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencyInjector();
    }

    /**
     * Inject every dependency declared in the object with the @Inject annotation if the dependency
     * has been already declared in a module and already initialized by Dagger.
     *
     * @param object to inject.
     */
    public void inject(Object object) {
        objectGraph.inject(object);
    }

    /**
     * Extend the dependency container graph will new dependencies provided by the modules passed as
     * arguments.
     *
     * @param modules used to populate the dependency container.
     */
    public ObjectGraph plus(List<Object> modules) {
        if (modules == null) {
            throw new IllegalArgumentException(
                    "You can't add a null module, review your getModules() implementation");
        }
        return objectGraph.plus(modules.toArray());
    }

    private void initializeDependencyInjector() {
        objectGraph = ObjectGraph.create(new AppModule(this));
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }
}
