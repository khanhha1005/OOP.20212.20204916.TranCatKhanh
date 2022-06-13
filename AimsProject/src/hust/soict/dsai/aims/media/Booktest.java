package hust.soict.dsai.aims.media;

import java.util.Arrays;
import java.util.List;

public class Booktest {

	public static void main(String[] args) {
		List<String> authors = Arrays.asList("Hello", "World!", "How", "Are", "You");
		String text = "Ann while Bob had had had had had had had had had had had a better effect on on the teacher" ;
		Media dd = new Book("The Lion King","Animation",authors,19.95f,text);
		((Book) dd).processContent();
		System.out.println(dd.toString());
	}

}
