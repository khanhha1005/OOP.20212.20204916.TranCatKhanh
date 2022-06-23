package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.Aims.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;



public class AddDigitalVideoDiscToStoreScreen extends AddItemsToStoreScreen {

	String director;
	String length;
	public AddDigitalVideoDiscToStoreScreen(Store store, JPanel storeScreenCenter) throws HeadlessException {
		super(store, storeScreenCenter);
		JPanel dirP = super.createSubPanel("Director");
		JPanel lenP = super.createSubPanel("Length");
		super.getCenterPanel().add(dirP, BorderLayout.CENTER);
		super.getCenterPanel().add(lenP, BorderLayout.CENTER);
		JButton btn = new JButton("Add");
		btn.addActionListener(new btnListener());
		super.getCenterPanel().add(btn, BorderLayout.SOUTH);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new btnListener());
		super.centerPanel.add(btnReset, BorderLayout.WEST);	
		
		super.setTitle("Add DVD to the Store");
	}
	
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add")) {
				for(JTextField tf: textFields) {
					if(tf.getName().equals("Title")) {
						title = tf.getText();
					}
					if(tf.getName().equals("Cost")) {
						cost = tf.getText();
					}
					if(tf.getName().equals("Category")) {
						category = tf.getText();
					}
					if(tf.getName().equals("Director")) {
						System.out.println(tf.getText());
						director = tf.getText();
					}
					if(tf.getName().equals("Length")) {
						length = tf.getText();
					}	
				}
				DigitalVideoDisc dvd;
				dvd = new DigitalVideoDisc(title, category, director,Integer.parseInt(length),Float.parseFloat(cost));
				store.addMedia(dvd);
				StoreScreenCenter.add(new MediaStore(dvd));
				StoreScreenCenter.repaint();
				StoreScreenCenter.revalidate();
			} else {
				for(JTextField tf: textFields) {
					tf.setText("");
				}
			}
		}
	}
}
