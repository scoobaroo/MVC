package MVC;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public abstract class View extends JPanel implements Observer{
	protected Model model;
	public View() {
		super();
	}
	public abstract void update(Observable o, Object arg);
	public void setModel(Model model) {
		this.model=model;
	}
	public Model getModel() {
		return model;
	}
}