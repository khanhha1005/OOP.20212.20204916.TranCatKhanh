package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

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
	public boolean equals(Object media) {
		if ( media instanceof Media) {
			Media that = (Media) media;
			if ((this.id == that.id) ) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public int compareTo(Media o) {
		if (this.getTitle().compareToIgnoreCase(o.getTitle())!= 0) {
			return this.getTitle().compareToIgnoreCase(o.getTitle());
		} else {
			return this.getCategory().compareToIgnoreCase(o.getCategory());
		}
			
	}
}
