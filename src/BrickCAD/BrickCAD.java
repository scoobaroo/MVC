package BrickCAD;
import java.awt.event.ActionEvent;
import MVC.*;

@SuppressWarnings("serial")
public class BrickCAD extends MVCApp{
	Brick brick = (Brick) BrickCAD.getModel();
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

	public static void main(String args[]) {
		System.out.println("Inside BrickCAD");
		BrickFactory bf = new BrickFactory();
		Brick brick = (Brick) bf.makeModel();
		BrickCAD.setModel(brick);
		BrickCAD.run(bf);
	}
}
