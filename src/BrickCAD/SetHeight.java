package BrickCAD;
import org.apache.commons.lang3.StringUtils;
import MVC.*;

public class SetHeight extends Command {
	protected Double newHeight=null;
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
		Brick brick = (Brick) getModel();
		System.out.println("Inside execute of SetHeight");
		if(newHeight==null){
			String newHeightString = Utilities.askUser("what is the new height?");
			if(StringUtils.isNumeric(newHeightString)){
				newHeight = Double.parseDouble(newHeightString);
			} else
				Utilities.informUser("Please enter a number");
		}
		brick.setHeight(newHeight);
	}
}
