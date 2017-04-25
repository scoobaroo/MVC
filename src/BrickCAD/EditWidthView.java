package BrickCAD;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextField;

import MVC.*;

@SuppressWarnings("serial")
public class EditWidthView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	AppFactory factory = MVCApp.getFactory();
	public EditWidthView(){
		setPreferredSize(new Dimension(200, 100));
	    JLabel width = new JLabel("Brick Width");
	    JTextField widthField = new JTextField("");
	    widthField.setText(String.valueOf(brick.getLength()));
	    this.add(width);
	    this.add(widthField);
		widthField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of heightField");
				int cmmd = e.getKeyCode();
				if(cmmd == KeyEvent.VK_ENTER){
					SetWidth setWidth = (SetWidth) factory.makeCommand("setwidth");
		    		CommandProcessor cp = CommandProcessor.getCommandProcessor();
		    		setWidth.newWidth = Double.parseDouble(widthField.getText());
		    		cp.execute(setWidth);
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