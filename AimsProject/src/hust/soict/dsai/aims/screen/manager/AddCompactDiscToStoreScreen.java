package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.Aims.Store;
import hust.soict.dsai.aims.exception.NegativePriceException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;


public class AddCompactDiscToStoreScreen extends AddItemsToStoreScreen {

	JButton btnAdd = new JButton("Add");
	JButton btnAddTracks = new JButton("Add Tracks");
    private ArrayList<Track> tracks= new ArrayList<Track>();

	CompactDisc disc;
	String director, length, artist;
	public AddCompactDiscToStoreScreen(Store store , JPanel storeScreenCenter) throws HeadlessException {
		super(store, storeScreenCenter);
		JPanel director = super.createSubPanel("Director");
		JPanel length = super.createSubPanel("Length");
		JPanel artist = super.createSubPanel("Artist");
		super.centerPanel.add(director, BorderLayout.CENTER);
		super.centerPanel.add(length, BorderLayout.CENTER);
		super.centerPanel.add(artist, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("Add CD");
		btnAdd.addActionListener(new btnListener());
		super.centerPanel.add(btnAdd,BorderLayout.SOUTH);
		
		JButton btnAddTracks = new JButton("Add Tracks");
		btnAddTracks.addActionListener(new btnListener());
		super.centerPanel.add(btnAddTracks,BorderLayout.CENTER);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new btnListener());
		super.centerPanel.add(btnReset, BorderLayout.WEST);	
		
		super.setTitle("Add CD");
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Add CD")) {
				for (JTextField tf : textFields) {
					if (tf.getName().equals("Title")) {
						title = tf.getText();
					}
					if (tf.getName().equals("Cost")) {
						cost = tf.getText();
					}
					if (tf.getName().equals("Category")) {
						category = tf.getText();
					}
					if (tf.getName().equals("Director")) {
						director = tf.getText();
					}
					if (tf.getName().equals("Length")) {
						length = tf.getText();
					}
					if (tf.getName().equals("Artist")) {
						artist = tf.getText();
					}
				} 
				CompactDisc disc;
				try {
					disc = new CompactDisc(title, category,  director,Integer.parseInt(length), Float.parseFloat(cost) , artist, tracks);
				} catch (NegativePriceException ex) {
					throw new RuntimeException(ex);
				}
				store.addMedia(disc);
				StoreScreenCenter.add(new MediaStore(disc));
				StoreScreenCenter.repaint();
				StoreScreenCenter.revalidate();
			} else if (e.getActionCommand().equals("Add CD")) {
				for (JTextField tf : textFields) {
					if (tf.getName().equals("Length")) {
						length = tf.getText();
					}
					if (tf.getName().equals("Title")) {
						title = tf.getText();
					}
				}
				Track track;
				track = new Track(title,Integer.parseInt(length));
				disc.addTracks(track);
			} else {
				for(JTextField tf: textFields) {
					tf.setText("");
				}
			}

		}
	}
}