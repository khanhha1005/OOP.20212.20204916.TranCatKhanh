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
	public boolean equals(Object track) {
		if (track instanceof Track) {
			Track that = (Track) track;
			if ((this.length == that.length) && (this.title.toLowerCase().equals(that.getTitle().toLowerCase()))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
    public String toString() {
        return "Title: " + this.getTitle()  + " Length: " + this.getLength() + "s";
    }
	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		return 0;
	}
}


