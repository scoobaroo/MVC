package MVC;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public abstract class View extends JPanel implements Observer{
	protected Model model;
	protected String title;
	public String getTitle(){
		return title;
	}
	public View(String title){
		super();
		this.title=title;
	}
	public View() {
		this("View");
	}
	public void update(Observable o, Object arg){
		repaint();
	};
	public void setModel(Model model) {
		this.model=model;
		model.addObserver(this);
	}
	public Model getModel() {
		return model;
	}
}