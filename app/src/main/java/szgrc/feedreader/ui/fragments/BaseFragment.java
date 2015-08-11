package szgrc.feedreader.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Base fragment created with the same function of base activity.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public abstract class BaseFragment extends Fragment{

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    /**
     * Avoiding duplicate all the inflate code in every fragment.
     */
    protected abstract int getFragmentLayout();

    /***
     * ButterKnife injector
     * @param view
     */
    private void injectViews(final View view) {
        ButterKnife.bind(this, view);
    }
}
