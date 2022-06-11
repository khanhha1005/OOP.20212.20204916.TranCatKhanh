package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	public int compare(Media m1, Media m2) {
		itemsOrdered.stream().sorted(Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));

	}
}