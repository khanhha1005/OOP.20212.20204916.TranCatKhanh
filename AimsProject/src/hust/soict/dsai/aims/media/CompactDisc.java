package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.NegativePriceException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist ;
    private ArrayList<Track> tracks= new ArrayList<Track>();
	public CompactDisc(String title, String category, String director, int length, float cost,String artist,ArrayList<Track> tracks)  throws NegativePriceException{
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
/*	public void play() {
    	for(int i = 0 ; i < tracks.size(); i++) {
    		(tracks).get(i).play();
    	}
	}*/
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println(" CD  " + this.getTitle()+"is playing");
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250,100);
			int w = d.getSize().width;
	        int h = d.getSize().height;
	        int x = (dim.width - w) / 2;
	        int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);
			
			for (Track track: this.tracks) {
				track.play();
			}
		} else { 
			throw new PlayerException("ERROR: CD length is non-positive!"); 
		}
	}
    public String toString() {
        StringBuilder tostringbook = new StringBuilder(super.toString());
        if (this.artist != null) {
            tostringbook.append("\n Artist: ").append(this.getArtist()).append("\n");
        }
        if (this.tracks != null) {
            tostringbook.append("Tracks: " + "\n");
            for (Track track : this.tracks) {
                tostringbook.append("Track: ").append(track.toString()).append("\n");
            }
        }
        return tostringbook.toString();
    }

}
