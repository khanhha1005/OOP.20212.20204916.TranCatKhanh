package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.exception.NegativePriceException;

public abstract class Media implements Comparable<Media> {
	private int id ;
	private String title ;
	private String category ;
	private float cost ;
	private LocalDate date;
	private static int nMedia=0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media(String title , String category , float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nMedia += 1;
		this.id = nMedia;
	}
	public Media(String title) {
		this.title = title;
		nMedia += 1;
		this.id = nMedia;
	}
	public Media(String title, String category, String cost) throws NumberFormatException, NegativePriceException {
		try {
			this.title = title;
			this.cost = Float.parseFloat(cost);
			if(this.cost < 0) {
				throw new NegativePriceException("Price  must be a positive number");
			}
			this.category = category;
		} catch (NumberFormatException e) {
			System.err.println("Price  must be a positive number");
			throw new NumberFormatException("Price  must be a positive number");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isMatch (String title) {
		String[] words = this.getTitle().split("\\s");
		for (int i=0 ; i < words.length; i++) {
			if (words[i].equals(title)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Media o) {
		if (this.getTitle().compareToIgnoreCase(o.getTitle())!= 0) {
			return this.getTitle().compareToIgnoreCase(o.getTitle());
		} else {
			return this.getCategory().compareToIgnoreCase(o.getCategory());
		}
			
	}
	public boolean equals(Object media) {
		try {
			if(media instanceof Media) {
				Media tmp = (Media) media;
				return tmp.getTitle().toLowerCase().equals(title.toLowerCase());
			}
		} catch (ClassCastException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.err.println("Class used to compare is null!");
		}
		
		return false;
	}
}
