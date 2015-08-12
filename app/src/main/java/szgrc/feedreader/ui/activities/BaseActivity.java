package szgrc.feedreader.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import szgrc.feedreader.FeedReaderApplication;
import szgrc.feedreader.di.ActivityModule;

/**
 * Base activity will be extended from every activity.
 *
 * It does the set up of the ButterKnife library and common methods to all activities.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public abstract class BaseActivity extends Activity{

    private ObjectGraph activityScopeGraph;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    /**
     * We can take all the views from each activity
     */
    private void injectViews() {
        ButterKnife.bind(this);
    }

    /**
     * Get a list of Dagger modules with Activity scope needed to this Activity.
     *
     * @return modules with new dependencies to provide.
     */
    protected abstract List<Object> getModules();

    /**
     * Create a new Dagger ObjectGraph to add new dependencies using a plus operation and inject the
     * declared one in the activity. This new graph will be destroyed once the activity lifecycle
     * finish.
     *
     * This is the key of how to use Activity scope dependency injection.
     */
    private void injectDependencies() {
        FeedReaderApplication tvShowsApplication = (FeedReaderApplication) getApplication();
        List<Object> activityScopeModules = getModules();
        activityScopeModules.add(new ActivityModule(this));
        activityScopeGraph = tvShowsApplication.plus(activityScopeModules);
        inject(this);
    }

    public void inject(Object object) {
        activityScopeGraph.inject(object);
    }
}
