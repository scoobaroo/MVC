package MVC;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public abstract class Model extends Observable implements Serializable{
	private String fileName="model";
	private Boolean unsavedChanges;
	public Model(String fileName) {
		super();
		this.fileName = fileName;
	}
	public Model(){
		this("");
	}
	public void changed(){
		unsavedChanges=true;
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}
	
	public abstract Memento makeMemento();
	public abstract void accept(Memento m);
	
	public String getFileName() {
		return this.fileName;
	}
	public void setFileName(String f){
		this.fileName = f;
	}
	public Boolean hasUnsavedChanges(){
		return this.unsavedChanges;
	}
	public void setUnsavedChanges(Boolean unsavedChanges){
		this.unsavedChanges = unsavedChanges;
	}
}
