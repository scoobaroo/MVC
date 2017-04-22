package BrickCAD;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import MVC.*;

public class BrickFactory implements AppFactory {
	List<String> commands = null;
	ArrayList<View> views = null;
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
			if(type.equalsIgnoreCase("setlength")) return new SetLength();
			if(type.equalsIgnoreCase("setwidth")) return new SetWidth();
			return null;
	}

	public View makeView(String cmmd) {
		if(cmmd.equalsIgnoreCase("topview")) return new TopView();
		if(cmmd.equalsIgnoreCase("sideview")) return new SideView();
		if(cmmd.equalsIgnoreCase("dview")) return new DimensionsView();
		if(cmmd.equalsIgnoreCase("frontview")) return new FrontView();
		return null;
	}
	
	@Override
	public ArrayList<View> getViews() {
//		views.add(topview);
//		views.add(sideview);
//		views.add(dimensionview);
//		views.add(frontview);
		return views;
	}

	@Override
	public List<String> getCommands() {
		commands.add("new");
		commands.add("edit");
		commands.add("quit");
		commands.add("undo");
		commands.add("redo");
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
