package BrickCAD;
import MVC.Command;
import MVC.Model;
import MVC.Utilities;

import org.apache.commons.lang3.StringUtils;

public class SetLength extends Command{
	protected Double newLength=null;
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
		Brick brick = (Brick) getModel();
		System.out.println("Inside execute of SetLength");
		if(newLength==null){
			String newLengthString=Utilities.askUser("what is the new length?");
			if(StringUtils.isNumeric(newLengthString)){
				newLength = Double.parseDouble(newLengthString);
			} else
				Utilities.error("Please enter a number");
		}
		brick.setLength(newLength);
	}
}
