package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hust.soict.dsai.aims.exception.NegativePriceException;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content ;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String,Integer> wordFrequency = new HashMap<String, Integer>();


	public Book(String title, String category, List<String> authors, float cost,String content) {
		super(title, category, cost);
		this.authors= authors;
		this.content = content;
	}
	public void processContent() {
		contentTokens = new ArrayList<String>(Arrays.asList(content.split(" ")));
	    for (String s : contentTokens) {
	        if (wordFrequency.containsKey(s)) {
	        	wordFrequency.put(s, wordFrequency.get(s) + 1);
	        } else {
	        	wordFrequency.put(s, 1);
	        }
	    }
	    System.out.println("word has processed");
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
		return "Book "+ this.getTitle()+" " + this.getCategory() + " " + this.getAuthors() +" : " + this.getCost() + " $" +" the content length : " +this.getContentTokens().size()+ " the  token list : "+ this.getContentTokens() + " the word frequency :"+ this.getWordFrequency();
	}
	public List<String> getContentTokens() {
		return contentTokens;
	}
	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}


}
