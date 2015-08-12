package szgrc.feedreader.ui.presenter;

/**
 * Base activity to have all the methods of the lifecycle of the presenters.
 *
 * Created by gonzalofernandez on 11/08/15.
 */
public abstract class BasePresenter {

    public abstract void init();

    public abstract void resume();

    public abstract void pause();
}
