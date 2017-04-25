package BrickCAD;

import MVC.*;

public class SetHeight extends Command {
	protected double newHeight;
	Brick brick = (Brick) getModel(),
	model = brick;
	public SetHeight(Model model) {
		super(model);
		commandName = "setHeight";
		setUndoable(true);
	}
	public SetHeight(){
		setModel(brick);
		commandName = "setHeight";
		setUndoable(true);
	}
	public void execute(){
		System.out.println("Inside execute of SetHeight");
		super.execute();
		brick.setHeight(newHeight);
		brick.changed();
	}
}
