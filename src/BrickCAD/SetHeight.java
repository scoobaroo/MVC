package BrickCAD;

import MVC.*;

public class SetHeight extends Command {
	protected double newHeight;
	public SetHeight(Model model) {
		super(model);
		commandName = "setHeight";
		setUndoable(true);
	}
	public SetHeight(){
		System.out.println("Inside constructor of SetHeight");
		commandName = "setHeight";
		setUndoable(true);
	}
	public void execute(){
		super.execute();
		Brick brick = (Brick) getModel(),
		model = brick;
		System.out.println("Inside execute of SetHeight");
		String newHeight = Utilities.askUser("what is the new height?");
		brick.setHeight(Double.parseDouble(newHeight));
		brick.changed();
	}
}
