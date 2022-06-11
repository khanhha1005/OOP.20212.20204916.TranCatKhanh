package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public int compare(Media m1, Media m2) {
	    private ArrayList<Media> items= new ArrayList<Media>();
	    items.add(m1);
	    items.add(m2);
		items.stream().sorted(Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));

	}
}
