package BrickCAD;
import MVC.*;

public class SetLength extends Command{
	public SetLength(Model model) {
		super(model);
		commandName = "setLength";
		setUndoable(true);
	}
	public SetLength(){
		commandName = "setLength";
		setUndoable(true);
	}
	Model model;
	double newLength;
	Brick brick = (Brick) getModel();
	public void execute(){
		super.execute();
		//make a new InternalFrame with a JInputField for newLength
		//set brick's length to new length
		brick.setLength(newLength);
		brick.changed();
	}
}
