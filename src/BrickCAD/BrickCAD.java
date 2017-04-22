package BrickCAD;
import java.awt.event.ActionEvent;

import javax.swing.*;

import MVC.*;

@SuppressWarnings("serial")
public class BrickCAD extends MVCApp{

	JDesktopPane desktop = getDesktop();
	CommandProcessor cp = CommandProcessor.getCommandProcessor();
	
	public BrickCAD(AppFactory factory) {
		super(factory);
	}

	public void actionPerformed(ActionEvent e){
    	String cmmd = e.getActionCommand();
    	AppFactory factory = getFactory();
    	if (cmmd.equalsIgnoreCase("setLength")) {
    		Command setLength = factory.makeCommand("setlength");
    		cp.execute(setLength);
    	} else if (cmmd.equalsIgnoreCase("setHeight")) {
    		Command setHeight = factory.makeCommand("setheight");
    		cp.execute(setHeight);
       	} else if (cmmd.equalsIgnoreCase("setWidth")) {
       		Command setWidth = factory.makeCommand("setwidth");
       		cp.execute(setWidth);
    	} 
    }
	public static void main(String args[]) {
		System.out.println("Inside BrickCAD");
		BrickFactory bf = new BrickFactory();
		MVCApp.run(bf);
		Brick brick = (Brick) bf.makeModel();
//		Command setHeight = bf.makeCommand("setheight");
//		Command setWidth = bf.makeCommand("setwidth");
//		Command setLength = bf.makeCommand("setlength");
		View topview= bf.makeView("topview");
		View sideview= bf.makeView("sideview");
		View frontview = bf.makeView("frontview");
		View dview = bf.makeView("dview");
		brick.addObserver(topview);
		brick.addObserver(sideview);
		brick.addObserver(frontview);
		brick.addObserver(dview);
		desktop.add(topview);
		topview.setSize(500, 300);
		topview.setVisible(true);
	}
}
