package BrickCAD;

import org.apache.commons.lang3.StringUtils;

import MVC.*;

public class SetWidth extends Command{
	protected Double newWidth=null;
	public SetWidth(Model model) {
		super(model);
		commandName = "setWidth";
		setUndoable(true);
	}
	public SetWidth(){
		System.out.println("Inside constructor of SetWidth");
		commandName = "setWidth";
		setUndoable(true);
	}
	public void execute(){
		super.execute();
		Brick brick = (Brick) getModel();
		if(newWidth==null){
			String newWidthString=Utilities.askUser("what is the new width?");
			if(StringUtils.isNumeric(newWidthString)){
				newWidth = Double.parseDouble(newWidthString);
			} else
				Utilities.error("Please enter a number");
		}
		brick.setWidth(newWidth);
	}
}
