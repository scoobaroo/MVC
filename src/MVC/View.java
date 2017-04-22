package MVC;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public abstract class View extends JPanel implements Observer{
	protected Model model;
	public View(){
		this(null);
	}
	
	public View(Model model) {
		super();
		this.model=model;
		JTextField newTitle = new JTextField("MVC App");
		this.add(newTitle);
	}
	public abstract void update(Observable o, Object arg);
	public void setModel(Model model) {
		this.model=model;
	}
	public Model getModel() {
		return model;
	}
}
