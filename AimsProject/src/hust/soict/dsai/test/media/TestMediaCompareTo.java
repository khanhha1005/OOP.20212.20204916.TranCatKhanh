package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.NegativePriceException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestMediaCompareTo {
    public static void main(String[] args) throws NegativePriceException {
        Media dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        Media dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);

        Media dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
	    ArrayList<Media> collection= new ArrayList<Media>();
		collection.add(dvd2);
		collection.add(dvd1);
		collection.add(dvd3);
		Iterator<Media> iterator = collection. iterator () ;
		System.out.println(dvd2.toString());
		System.out.println ("-");
		System.out.println ("The DVDs in currently sorted order are: ") ;
		while (iterator.hasNext () ) {
			System. out. println
			(( (Media) iterator. next () ) .getTitle () ) ;
		}
		Collections.sort(collection);
		iterator = collection.iterator () ;
		System. out. println ("-");
		System. out. println ("The DVDs in sorted order are: ") ;
		while (iterator.hasNext () ) {
			System. out. println
			(( (Media) iterator. next () ) .getTitle () ) ;
		}
	}
}
