package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, List<String> authors, float cost) {
		super(title, category, cost);
		this.authors= authors;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void addAuthor(String authorName) {
		if (authors.size() == 0) {
			authors.add(authorName);
		}
		else if (authors.indexOf(authorName)== -1 ) {
			authors.add(authorName);
			System.out.println(authors);
		}
		else {
			System.out.println("this author has been added");
			System.out.println(authors);

		}
	}
	public void removeAuthor(String authorName) {
		int find = authors.indexOf(authorName);
		if (find != -1 ) {
			authors.remove(authorName);
			System.out.print(authors);
		}else {
			System.out.print("this authors doesn't exits");
		}
	}
	public String toString() {
		return "Book "+ this.getTitle()+" " + this.getCategory() + " " + this.getAuthors() +" : " + this.getCost() + " $" ;
	}

}
