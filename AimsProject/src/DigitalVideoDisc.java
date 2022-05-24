import java.time.LocalDate;
import java.util.Comparator;
public class DigitalVideoDisc {
	private String title ;
	private String category ;
	private String director;
	private int length ;
	private float cost ;
	private int id ; 
	private LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;


	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs ;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs ;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs += 1;
		this.id = nbDigitalVideoDiscs ;
	}
	public void setTitle(String title2) {
		this.title = title2 ; 	
	}
	public boolean isMatch (String title) {
		String[] words = this.title.split("\\s");
		for (int i=0 ; i < words.length; i++) {
			if (words[i].equals(title)){
				return true;
			}
		}
		return false;
	}
	public String toString() {
		return "DVD "+ this.title+" " + this.category + " " + this.director +" "+ this.length +" : " + this.cost + " $" ;
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
}