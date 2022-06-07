package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private int length;
	private String title;
	public Track(String title , int length ) {
		this.length = length ;
		this.title = title ;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}			
}


