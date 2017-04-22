package BrickCAD;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MVC.*;

@SuppressWarnings("serial")
public class DimensionsView extends View {
	Brick brick = (Brick) getModel();
	public DimensionsView() {
		super();
		brick.addObserver(this);
		setLayout(new BorderLayout());
		JLabel title = new JLabel("Brick Attributes");
		this.add(title, BorderLayout.NORTH);
		JLabel directions = new JLabel("Type text in a field and press enter");
		this.add(directions, BorderLayout.SOUTH);
		JLabel label1 = new JLabel("Height");
		JTextField textField1 = new JTextField(30);
		textField1.setText(String.valueOf(brick.getHeight()));
		JLabel label2 = new JLabel("Width");
		JTextField textField2 = new JTextField(30);
		textField2.setText(String.valueOf(brick.getWidth()));
		JLabel label3 = new JLabel("Length");
		JTextField textField3 = new JTextField(30);
		textField3.setText(String.valueOf(brick.getLength()));
		this.add(label1,BorderLayout.WEST);
		this.add(textField1,BorderLayout.CENTER);
		this.add(label2,BorderLayout.WEST);
		this.add(textField2,BorderLayout.CENTER);
		this.add(label3,BorderLayout.WEST);
		this.add(textField3,BorderLayout.CENTER);
		textField1.addActionListener((ActionListener) this);
		textField2.addActionListener((ActionListener) this);
		textField3.addActionListener((ActionListener) this);
		Double newHeight = Double.parseDouble(textField1.getText());
		Double newWidth = Double.parseDouble(textField2.getText());
		Double newLength = Double.parseDouble(textField3.getText());
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
