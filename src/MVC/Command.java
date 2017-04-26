package MVC;

public abstract class Command {
	private boolean undoable;
	protected Model model;
	private Memento memento;
	public String commandName;
	public Command(){
	}
	public boolean isUndoable() {
		return undoable;
	}
	public void setUndoable(boolean undoable) {
		this.undoable = undoable;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Memento getMemento() {
		return memento;
	}
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	public Command(Model model) {
		this.model = model;
	}
	public void execute(){
		memento = model.makeMemento();
	}
	public void undo(){
		if(undoable && memento!=null) model.accept(memento);
	}
}
