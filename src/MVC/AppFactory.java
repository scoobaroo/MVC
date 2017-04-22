package MVC;

import java.util.List;

public interface AppFactory {
	public Model makeModel();
	public View makeView(String cmmd);
	public Command makeCommand(String type);
	public List<View> getViews();
	public List<String> getCommands();
	public String getHelp();
	public String getTitle();
	public String about();
}
