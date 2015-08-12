package szgrc.feedreader.domain.feed;

import java.io.Serializable;

/**
 * Created by gonzalofernandez on 11/08/15.
 */
public class Feed implements Serializable {

    public final String id;
    public final String title;
    public final String description;
    public final String image;

    public Feed(String id, String title, String description, String image){
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
    }


}
