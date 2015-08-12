package szgrc.feedreader.ui.activities;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

import szgrc.feedreader.R;
import szgrc.feedreader.ui.fragments.FeedListFragment;

/**
 * Activity to show the list of feeds got from the API or from database if there is no internet connection.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public class FeedsListActivity extends BaseActivity {

    private FeedListFragment feedListFragment;
//    private FeedDetailsFragment feedDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTvShowFragment();
    }

    @Override
    protected List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new FeedListModule(feedListFragment));
        return modules;
    }

    private void initializeTvShowFragment() {
        feedListFragment = (FeedListFragment) getFragmentManager().findFragmentById(R.id.fragmentFeedList);
    }

}
