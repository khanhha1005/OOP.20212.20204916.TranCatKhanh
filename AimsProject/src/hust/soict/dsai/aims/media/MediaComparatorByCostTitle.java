package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	public int compare(Media media, Media media1) {
		if (media.getCost() < media1.getCost()) {
			return 1;
		} else if (media.getCost() > media1.getCost()) {
			return -1;
		} else {
			return media.getTitle().compareToIgnoreCase(media1.getTitle());
		}
	}
}
