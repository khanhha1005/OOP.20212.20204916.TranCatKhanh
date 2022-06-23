package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.Aims.Store;


public abstract class AddItemsToStoreScreen extends JFrame {
	JPanel centerPanel;
	JPanel StoreScreenCenter;
	Store store; 
	String title, category, cost;
	private JPanel center;

	ArrayList<JTextField> textFields = new ArrayList<JTextField>(); 

	public AddItemsToStoreScreen(Store store,  JPanel storeScreenCenter) throws HeadlessException {
		this.store = store;
		this.StoreScreenCenter = storeScreenCenter;
		this.setSize(700, 400);
		
		this.setLayout(new BorderLayout());
		this.add(createCenter(), BorderLayout.CENTER);
		this.add(createMenuBar(),BorderLayout.NORTH);
		this.setVisible(true);
	}
	protected JPanel getCenterPanel() {
		return this.centerPanel;
	}
	
	protected JPanel createSubPanel(String text) {
		JPanel subContainer = new JPanel(new FlowLayout());
		JTextField tf = new JTextField(50);
		tf.setName(text);
		textFields.add(tf);
		JLabel lb = new JLabel(text);
		subContainer.add(lb);
		subContainer.add(tf);
		subContainer.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		return subContainer;
		
	}
	JPanel createCenter() {
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(10, 1, 5, 5));
		
		JPanel titleP = createSubPanel("Title");
		JPanel costP = createSubPanel("Cost");
		JPanel categoryP = createSubPanel("Category");
		
		centerPanel.add(titleP);
		centerPanel.add(costP);
		centerPanel.add(categoryP);
		
		return centerPanel;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store"); 
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		smUpdateStore.add(addBookMenu);
		smUpdateStore.add(addCDMenu);
		smUpdateStore.add(addDVDMenu);
		addBookMenu.addActionListener(new btnListener());
		addDVDMenu.addActionListener(new btnListener());
		addCDMenu.addActionListener(new btnListener());
		menu.add(smUpdateStore);
		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnListener());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}

	private class btnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if(command.equals("View Store")) {
				new StoreManagerScreen(store);
				dispose();
			}
			if(command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store, center);
			}
			if(command.equals("Add Book")) {
				new AddBookToStoreScreen(store, center);
			}
			if(command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store, center);
			}
		}
		
		
	}
}