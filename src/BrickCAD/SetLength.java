package BrickCAD;

import MVC.*;

public class SetLength extends Command{
	protected double newLength;
	Brick brick = (Brick) getModel(),
	model=brick;
	public SetLength(Model model) {
		super(model);
		commandName = "setLength";
		setUndoable(true);
	}
	public SetLength(){
		setModel(brick);
		commandName = "setLength";
		setUndoable(true);
	}
	public void execute(){
		System.out.println("Inside execute of SetLength");
		super.execute();
		brick.setLength(newLength);
		brick.changed();
	}
}
