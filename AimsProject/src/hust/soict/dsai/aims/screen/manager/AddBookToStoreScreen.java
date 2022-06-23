package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.Aims.Store;
import hust.soict.dsai.aims.media.Book;


public class AddBookToStoreScreen extends AddItemsToStoreScreen {
	String content;
	String authors;
	private List<String> authors1 = new ArrayList<String>();

	public AddBookToStoreScreen(Store store, JPanel storeScreenCenter) throws HeadlessException {
		super(store,  storeScreenCenter);
		JPanel authors = super.createSubPanel("Authors");
		JPanel content = super.createSubPanel("Content");

		super.centerPanel.add(authors, BorderLayout.CENTER);
		super.centerPanel.add(content, BorderLayout.CENTER);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new btnListener());
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new btnListener());
	
		super.centerPanel.add(btnReset, BorderLayout.WEST);	
		super.centerPanel.add(btnAdd, BorderLayout.SOUTH);
		super.setTitle("Add Book to the Store");
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
					if(tf.getName().equals("Authors")) {
						authors = tf.getText();
					}
					if(tf.getName().equals("Content")) {
						content = tf.getText();
					}
	
				}
				authors1.add(authors);
				Book book1;
				book1 = new Book(title, category, authors1,Float.parseFloat(cost),content);
				store.addMedia(book1) ;
				StoreScreenCenter.add(new MediaStore(book1));
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