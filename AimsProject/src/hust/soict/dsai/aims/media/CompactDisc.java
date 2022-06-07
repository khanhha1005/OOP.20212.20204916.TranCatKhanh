package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist ;
    private ArrayList<Track> tracks= new ArrayList<Track>();
	public CompactDisc(String title, String category, String director, int length, float cost,String artist,ArrayList<Track> tracks) {
		super(title,category,director,length,cost);
		this.artist = artist ;
		this.tracks = tracks ;
	}
	public String getArtist() {
		return artist;
	}
    public void addTracks(Track track) {
    	if (tracks.contains(track)) {
    		System.out.println("The track is already in the list of tracks ");
    	}else {
    		tracks.add(track);
    		System.out.println("The track has been added");
    	}
    }
    public void removeTracks(Track track) {
    	if (tracks.contains(track)) {
    		tracks.remove(track);
    	}else {
    		System.out.println("The track is not in the list of tracks");
    	}
    }
    public int getLength() {
    	int length = 0 ;
    	for(int i = 0 ; i < tracks.size(); i++) {
    		length += tracks.get(i).getLength();
    	}
    	return length ;
    }
	@Override
	public void play() {
    	for(int i = 0 ; i < tracks.size(); i++) {
    		(tracks).get(i).play();
    	}
	}

}
