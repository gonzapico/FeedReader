package szgrc.feedreader.ui.activities;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Base activity will be extended from every activity.
 *
 * It does the set up of the ButterKnife library and common methods to all activities.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public class BaseActivity extends Activity{


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectViews();
    }

    /**
     * We can take all the views from each activity
     */
    private void injectViews() {
        ButterKnife.bind(this);
    }
}
