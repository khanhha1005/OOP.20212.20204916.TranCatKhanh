package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.NegativePriceException;

public class Disc extends Media {
	private String director;
	private int length ;
	public Disc(String title, String category, String director, int length, float cost)throws NegativePriceException {
		super(title,category, cost);
		this.setDirector(director);
		this.setLength(length);
	}
	public Disc(String title, String category, float cost)throws NegativePriceException {
		super(title,category , cost);
	}
	public Disc(String title) {
		super(title);
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
