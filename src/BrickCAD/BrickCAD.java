package BrickCAD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import MVC.*;

@SuppressWarnings("serial")
public class BrickCAD extends MVCApp{
	Brick brick = (Brick) MVCApp.getModel();
	CommandProcessor cp = CommandProcessor.getCommandProcessor();
	
	public BrickCAD(AppFactory factory) {
		super(factory);
	}
	public void actionPerformed(ActionEvent e){
    	String cmmd = e.getActionCommand();
    	if (cmmd.equalsIgnoreCase("setLength")) {
    		Command setLength = getFactory().makeCommand("setlength");
    		cp.execute(setLength);
    	} 
    	else if (cmmd.equalsIgnoreCase("setHeight")) {
    		Command setHeight = getFactory().makeCommand("setheight");
    		cp.execute(setHeight);
       	} 
    	else if (cmmd.equalsIgnoreCase("setWidth")) {
       		Command setWidth = getFactory().makeCommand("setwidth");
       		cp.execute(setWidth);
    	}
	}
	
	public void actionPerformed(KeyEvent e){
    	int cmmd = e.getKeyCode();
    	if (cmmd==KeyEvent.VK_ENTER) {
    		Command setLength = getFactory().makeCommand("setlength");
    		Command setHeight = getFactory().makeCommand("setheight");
    		Command setWidth = getFactory().makeCommand("setwidth");
    		cp.execute(setLength);
    		cp.execute(setHeight);
    		cp.execute(setWidth);
    	} 
    }

	public static void main(String args[]) {
		System.out.println("Inside BrickCAD");
		BrickFactory bf = new BrickFactory();
		Brick brick = (Brick) bf.makeModel();
		BrickCAD.setModel(brick);
		BrickCAD.run(bf);
	}
}
