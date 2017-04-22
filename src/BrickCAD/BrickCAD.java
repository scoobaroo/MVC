package BrickCAD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import MVC.*;

@SuppressWarnings("serial")
public class BrickCAD extends MVCApp{

	CommandProcessor cp = CommandProcessor.getCommandProcessor();
	public BrickCAD(AppFactory factory) {
		super(factory);
		editMenu();
	}
	protected void editMenu(){
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_A);
        menubar.add(editMenu);
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_W);
        menubar.add(viewMenu);
 
        JMenuItem menuItem = new JMenuItem("Undo");
        menuItem.setMnemonic(KeyEvent.VK_U);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_U, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("undo");
        menuItem.addActionListener(this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Redo");
        menuItem.setMnemonic(KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("redo");
        menuItem.addActionListener(this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Edit Height");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_H, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editheight");
        menuItem.addActionListener(this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Edit Width");
        menuItem.setMnemonic(KeyEvent.VK_W);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_W, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editwidth");
        menuItem.addActionListener(this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Edit Length");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_L, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editlength");
        menuItem.addActionListener(this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Side View");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("sideview");
        menuItem.addActionListener(this);
        viewMenu.add(menuItem);
        
        menuItem = new JMenuItem("Top View");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_T, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("topview");
        menuItem.addActionListener(this);
        viewMenu.add(menuItem);
       
        menuItem = new JMenuItem("Front View");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("frontview");
        menuItem.addActionListener(this);
        viewMenu.add(menuItem);
        
        menuItem = new JMenuItem("Dimensions View");
        menuItem.setMnemonic(KeyEvent.VK_D);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("dview");
        menuItem.addActionListener(this);
        viewMenu.add(menuItem);
        
	}

	public void actionPerformed(ActionEvent e){
    	String cmmd = e.getActionCommand();
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
       	else if (cmmd.equalsIgnoreCase("topview")) {
	   		View topview = factory.makeView("topview");
	   		desktop.add(topview);
		} 
       	else if (cmmd.equalsIgnoreCase("sideview")) {
	   		View sideview = factory.makeView("sideview");
	   		desktop.add(sideview);
		} 
       	else if (cmmd.equalsIgnoreCase("topview")) {
	   		View frontview = factory.makeView("frontview");
	   		desktop.add(frontview);
		} 
       	else if (cmmd.equalsIgnoreCase("dview")) {
	   		View dview = factory.makeView("dview");
	   		desktop.add(dview);
		} 
    }
	
	public void actionPerformed(KeyEvent e){
    	int cmmd = e.getKeyCode();
    	AppFactory factory = getFactory();
    	if (cmmd==KeyEvent.VK_ENTER) {
    		Command setLength = factory.makeCommand("setlength");
    		Command setHeight = factory.makeCommand("setheight");
    		Command setWidth = factory.makeCommand("setwidth");
    		cp.execute(setLength);
    		cp.execute(setHeight);
    		cp.execute(setWidth);
    	} 
    }

	public static void main(String args[]) {
		System.out.println("Inside BrickCAD");
		BrickFactory bf = new BrickFactory();
		BrickCAD bc = new BrickCAD(bf);
		Brick brick = (Brick) bf.makeModel();
		bc.run(bf);
	}
}
