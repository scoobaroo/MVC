package BrickCAD;

import MVC.*;

public class SetWidth extends Command{
	protected double newWidth;
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
		Brick brick = (Brick) getModel(),
		model=brick;
		String newWidth=Utilities.askUser("what is the new width?");
		brick.setWidth(Double.parseDouble(newWidth));
		brick.changed();
	}
}
