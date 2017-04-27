package BrickCAD;
import MVC.Command;
import MVC.Model;
import MVC.Utilities;
import org.apache.commons.lang3.StringUtils;

public class SetLength extends Command{
	protected double newLength;
	public SetLength(Model model) {
		super(model);
		commandName = "setLength";
		setUndoable(true);
	}
	public SetLength(){
		commandName = "setLength";
		setUndoable(true);
	}
	public void execute(){
		super.execute();
		Brick brick = (Brick) getModel(),
		model=brick;
		System.out.println("Inside execute of SetLength");
		String newLength=Utilities.askUser("what is the new length?");
		if(StringUtils.isNumeric(newLength)){
			brick.setLength(Double.parseDouble(newLength));
			brick.changed();
		} else
			Utilities.informUser("Please enter a number");
	}
}
