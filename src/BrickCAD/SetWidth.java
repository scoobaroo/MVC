package BrickCAD;

import MVC.*;

public class SetWidth extends Command{
	public SetWidth(Model model) {
		super(model);
		commandName = "setWidth";
		setUndoable(true);
	}
	public SetWidth(){
		commandName = "setWidth";
		setUndoable(true);
	}
	double newWidth;
	Brick brick = (Brick) getModel();
	public void execute(){
		super.execute();
		//make a new InternalFrame with a JInputField for newWidth
		//set brick's width to new width
		brick.setWidth(newWidth);
		brick.changed();
	}
}
