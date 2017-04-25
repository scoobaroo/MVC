package BrickCAD;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MVC.*;

@SuppressWarnings("serial")
public class EditLengthView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	AppFactory factory = MVCApp.getFactory();
	public EditLengthView(){
		setPreferredSize(new Dimension(200, 100));
	    JLabel length = new JLabel("Brick Length");
	    JTextField lengthField = new JTextField("");
	    lengthField.setText(String.valueOf(brick.getLength()));
		this.add(length);
		this.add(lengthField);
		lengthField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of heightField");
				int cmmd = e.getKeyCode();
				if(cmmd == KeyEvent.VK_ENTER){
					SetLength setLength = (SetLength) factory.makeCommand("setlength");
		    		CommandProcessor cp = CommandProcessor.getCommandProcessor();
		    		setLength.newLength = Double.parseDouble(lengthField.getText());
		    		cp.execute(setLength);
				}
			}
			public void keyReleased(KeyEvent e) {}
		});
	}
	@Override
	public void update(Observable o, Object arg) {
	}
}