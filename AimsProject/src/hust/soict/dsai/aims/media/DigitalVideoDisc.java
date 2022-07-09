package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.exception.NegativePriceException;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length ;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws NegativePriceException {
		super(title,category, cost);
		this.length= length;
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, float cost)throws NegativePriceException {
		super(title,category,cost);
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public String toString() {
		return "DVD "+ this.getTitle()+" category " + this.getCategory() + " director  " + this.director +" length "+ this.length +" : " + this.getCost() + " $" ;
	}
	public boolean compareto(DigitalVideoDisc o,DigitalVideoDisc j ){
		if (o.getTitle().compareTo(j.getTitle()) > 1){
			return true ;
		}else if (o.getCost()<j.getCost()){
			return true ;
		} else if (o.getLength()< j.getLength()) {
			return true ;
		}
		return false;
	}
	public void play() throws PlayerException {
		if (this.getLength()>0) {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
	

}