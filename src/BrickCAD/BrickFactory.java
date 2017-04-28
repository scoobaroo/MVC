package BrickCAD;
import java.util.*;
import MVC.*;

public class BrickFactory implements AppFactory {
	List<String> commands = null;
	List<String> views = null;
	private String title="Brick CAD";
	private String help="Please consult ReadMe.";
	private String about="Brick CAD is an application for designing bricks. It uses the MVC and Publisher/Subscriber "
			+ "pattern to do this. You can edit the properties of a brick, undo, redo, and save any changes you have made "
			+ "It is intended for educational purposes only.";
	
	public Model makeModel() {
		return new Brick();
	}

	public Command makeCommand(String type) {
			if(type.equalsIgnoreCase("setheight")) return new SetHeight();
			else if(type.equalsIgnoreCase("setlength")) return new SetLength();
			else if(type.equalsIgnoreCase("setwidth")) return new SetWidth();
			else return null;
	}

	public View makeView(String cmmd) {
		System.out.println("inside makeView method in BrickFactory");
		if(cmmd.equalsIgnoreCase("topview")) return new TopView("Top View");
		else if(cmmd.equalsIgnoreCase("sideview")) return new SideView("Side View");
		else if(cmmd.equalsIgnoreCase("dimensionsview")) return new DimensionsView("Dimensions View");
		else if(cmmd.equalsIgnoreCase("frontview")) return new FrontView("Front View");
		else return null;
	}
	
	@Override
	public List<String> getViews() {
		ArrayList<String> views = new ArrayList<>();
		views.add("topview");
		views.add("sideview");
		views.add("frontview");
		views.add("dimensionsview");
		return views;
	}

	@Override
	public List<String> getCommands() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("setheight");
		commands.add("setlength");
		commands.add("setwidth");
		return commands;
	}

	@Override
	public String getHelp() {
		return help;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String about() {
		return about;
	}
}
