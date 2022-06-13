package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class classname {

	public static void main(String[] args) {
		List<Media> media = new ArrayList<Media>( ) ;
		// create some media here
		// for example: cd, dvd, book
        Media cd = new CompactDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f, "hk", null);

        Media dvd = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
		List<String> authors = Arrays.asList("Hello", "World!", "How", "Are", "You");
		String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher" ;
		Media Book = new Book("The Lion King","Animation",authors,19.95f,text);
		media.add(cd ) ;
		media.add(dvd ) ;
		media.add(Book) ;
		for (Media m: media) {
			System.out.println(m.toString()) ;
		}
	}
}
