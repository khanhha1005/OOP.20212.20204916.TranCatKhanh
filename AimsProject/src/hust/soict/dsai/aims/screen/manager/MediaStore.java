package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.swing.NumberGrid.ButtonListener;
import hust.soict.dsai.swing.SwingAccumulator.TFInputListener;

public class MediaStore extends JPanel implements ActionListener {
	private Media media;
    static JFrame f;

	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT) ;
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {	
			JButton playButton = new JButton("Play");
			container.add(playButton);

	        playButton.addActionListener(new TFInputListener());

		}

		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	private class TFInputListener implements ActionListener { 
	
		public void actionPerformed(ActionEvent e) 
		    {
		        String s = e.getActionCommand();
		        if (s.equals("Play")) {
		            JDialog d = new JDialog(f, "Play Box");
		            JLabel l = new JLabel("The Media "+media.getTitle()+" is playing",SwingConstants.CENTER);
		    		l.setFont(new Font(l.getFont().getName(), Font.PLAIN, 15));

		            d.add(l);
		            d. setLocationRelativeTo(null);        
		            d.setSize(500, 200);
		 
		            d.setVisible(true);
		        }
		}
		
	}
}
