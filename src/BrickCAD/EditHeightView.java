package BrickCAD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MVC.*;

@SuppressWarnings("serial")
public class EditHeightView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	AppFactory factory = MVCApp.getFactory();
	public EditHeightView(){
		setPreferredSize(new Dimension(200, 100));
		brick.addObserver(this);
	    JLabel height = new JLabel("Brick Height");
	    JTextField heightField = new JTextField("");
	    heightField.setText(String.valueOf(brick.getHeight()));
		this.add(height);
		this.add(heightField);
		heightField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of heightField");
				int cmmd = e.getKeyCode();
				if(cmmd == KeyEvent.VK_ENTER){
					SetHeight setHeight = (SetHeight) factory.makeCommand("setheight");
		    		CommandProcessor cp = CommandProcessor.getCommandProcessor();
		    		setHeight.newHeight = Double.parseDouble(heightField.getText());
		    		cp.execute(setHeight);
				}
			}
			public void keyReleased(KeyEvent e) {}
		});
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}