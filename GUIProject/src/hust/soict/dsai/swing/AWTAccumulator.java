package hust.soict.dsai.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
	private TextField tfInput ;
	private TextField tfOutput ;
	private int sum = 0 ;
	public AWTAccumulator() {
		setLayout(new GridLayout(2,2));
		add(new Label("Enter an Interger: "));
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new IFInputListener());
		add(new Label("The Accumulated Sum is: ")) ;
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		setTitle("AWT Accumlator");
		setSize(350,120);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	private class IFInputListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn ;
			tfInput.setText("");
			tfOutput.setText(sum + " ");
		}
	}
}
