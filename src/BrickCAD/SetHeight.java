package BrickCAD;

import MVC.*;

public class SetHeight extends Command {

	public SetHeight(Model model) {
		super(model);
		commandName = "setHeight";
		setUndoable(true);
	}
	public SetHeight(){
		commandName = "setHeight";
		setUndoable(true);
	}
	double newHeight;
	Brick brick = (Brick) getModel();
	public void execute(){
		super.execute();
		//make a new InternalFrame with a JInputField for newHeight
		//set brick's height to new height
		brick.setHeight(newHeight);
		brick.changed();
	}
}
