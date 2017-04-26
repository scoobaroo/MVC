package BrickCAD;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.*;@SuppressWarnings("serial")
public class DimensionsView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	AppFactory factory = MVCApp.getFactory();
	public DimensionsView(String title) {
		super();
		this.title = title;
		System.out.println(brick);
		setSize(200,200);
		brick.addObserver(this);
        JPanel buttonPane = new JPanel();
        JPanel fieldsPanel = new JPanel();
        JLabel attributes = new JLabel("Brick Attributes");
        JLabel height = new JLabel("Height");
        JLabel width = new JLabel("Width");
        JLabel length = new JLabel("Length");
        JLabel directions = new JLabel("Type text in a field and press Enter");
        
        JTextField heightField = new JTextField("");
        JTextField widthField = new JTextField("");
        JTextField lengthField = new JTextField("");

        heightField.setText(String.valueOf(brick.getHeight()));
        widthField.setText(String.valueOf(brick.getWidth()));
        lengthField.setText(String.valueOf(brick.getLength()));
        
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));

        fieldsPanel.add(attributes);
        fieldsPanel.add(height);
        fieldsPanel.add(heightField);
        fieldsPanel.add(width);
        fieldsPanel.add(widthField);
        fieldsPanel.add(length);
        fieldsPanel.add(lengthField);
        fieldsPanel.add(directions);
        
        this.add(fieldsPanel, BorderLayout.PAGE_START);
        this.add(buttonPane, BorderLayout.PAGE_END);
		lengthField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of lengthField in dview");
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
		heightField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of heightField in dview");
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
		widthField.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("inside keyPressed actionListener of widthField in dview");
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
