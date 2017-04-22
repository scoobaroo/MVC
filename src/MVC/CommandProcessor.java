package MVC;

import java.util.Stack;

public class CommandProcessor {
	private Stack<Command> undoStack, redoStack;
	private static CommandProcessor commandProcessor;
    
	private CommandProcessor() {
    }
    
	public static CommandProcessor makeCommandProcessor() {
		return null;
	}

    public static CommandProcessor getCommandProcessor() {
        if (null == commandProcessor) {
            commandProcessor = new CommandProcessor();
        }
        return commandProcessor;
    }
    
	public void undo() {
		if(!undoStack.empty()){
			Command top = undoStack.pop();
			top.undo();
			redoStack.push(top);
		}
	}

	public void redo() {
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
