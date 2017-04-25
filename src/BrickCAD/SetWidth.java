package BrickCAD;

import MVC.*;

public class SetWidth extends Command{
	protected double newWidth;
	Brick brick = (Brick) getModel(),
	model = brick;
	public SetWidth(Model model) {
		super(model);
		commandName = "setWidth";
		setUndoable(true);
	}
	public SetWidth(){
		System.out.println("Inside execute of SetWidth");
		setModel(brick);
		commandName = "setWidth";
		setUndoable(true);
	}
	public void execute(){
		super.execute();
		brick.setWidth(newWidth);
		brick.changed();
	}
}
