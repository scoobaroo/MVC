package MVC;

import java.util.Stack;

public class CommandProcessor {
	private Stack<Command> undoStack, redoStack;
	
	private static CommandProcessor commandProcessor=null;
    
	private CommandProcessor() {
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
    }
    
	public static CommandProcessor makeCommandProcessor() {
		if (null == commandProcessor) {
			commandProcessor = new CommandProcessor();
		}
		return commandProcessor;
	}

    public static CommandProcessor getCommandProcessor() {
        if (null == commandProcessor) {
            commandProcessor = new CommandProcessor();
        }
        return commandProcessor;
    }
    
	public void undo() {
		System.out.println("Inside undo");
		if(!undoStack.empty()){
			Command top = undoStack.pop();
			top.undo();
			redoStack.push(top);
		}
	}
	public void redo() {
		System.out.println("Inside redo");
		if(!redoStack.empty()){
			Command redo = redoStack.pop();
			redo.execute();
			undoStack.push(redo);
		}
	}
	public void execute(Command cmmd){
		cmmd.execute();
		if(cmmd.isUndoable()){
			undoStack.push(cmmd);
			redoStack.clear();
		}
	}
}
