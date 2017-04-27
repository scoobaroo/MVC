package MVC;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import BrickCAD.Brick;

@SuppressWarnings("serial")
public class MVCApp extends JFrame implements ActionListener {

	protected static JDesktopPane desktop;
	private static AppFactory factory;
	private static Model model;
	private static CommandProcessor commandProcessor;
	protected static JMenuBar menubar = new JMenuBar();
	public ArrayList<String> commands = null;
	public ArrayList<String> views = null;

	public void setupEditMenu(){
		commands.add("new");
		commands.add("save");
		commands.add("saveas");
		commands.add("edit");
		commands.add("quit");
		commands.add("undo");
		commands.add("redo");
	}
	static String[] fileOptions = {"new","open","save", "saveas", "quit"};
	static String[] editOptions = {"redo","undo"};
	static String[] helpOptions = {"help","about"};
	static String[] viewOptions = {};
	
	public MVCApp(AppFactory factory) {

		this.setFactory(factory);
		model = factory.makeModel();
		this.commandProcessor = CommandProcessor.makeCommandProcessor();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		desktop = new JDesktopPane(); //a specialized layered pane

		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset,screenSize.width  - inset*2,screenSize.height - inset*2);

		//create first "window" here (I forgot to do this)

		setContentPane(desktop);
		setJMenuBar(createMenuBar());

		//Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	}

	
	public static JDesktopPane getDesktopPane(){
		return desktop;
	}

	protected JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu filemenu = Utilities.makeMenu("File", fileOptions, this);
		JMenu helpmenu = Utilities.makeMenu("Help", helpOptions, this);
		JMenu editmenu = Utilities.makeMenu("Edit", factory.getCommands().toArray(new String[0]), new EditHandler());
		JMenu viewmenu = Utilities.makeMenu("View",factory.getViews().toArray(new String[0]), new ViewHandler());
		menubar.add(filemenu);
		menubar.add(editmenu);
		menubar.add(viewmenu);
		menubar.add(helpmenu);

        JMenuItem menuItem = new JMenuItem("undo");
        menuItem.setMnemonic(KeyEvent.VK_U);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_U, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("undo");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);
        
        menuItem = new JMenuItem("redo");
        menuItem.setMnemonic(KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("redo");
        menuItem.addActionListener(this);
        editmenu.add(menuItem);

        return menubar;
    }

	public void actionPerformed(ActionEvent e){
    	String cmmd = e.getActionCommand();
    	if (cmmd == "save") {
    		Utilities.save(model);
    	} else if (cmmd == "saveas") {
    		Utilities.saveAs(model);
    	} else if (cmmd == "open") {
    		try {
				Utilities.open(model);
			} catch (IOException | ClassNotFoundException ex) {
				ex.printStackTrace();
			}
    	} else if (cmmd == "new") {
    		Utilities.saveChanges(model);
    		model = factory.makeModel();
    		MVCApp.setModel(model);
    	} else if (cmmd == "undo") {
    		commandProcessor.undo();
    	} else if (cmmd == "redo") {
    		commandProcessor.redo();
    	} else if (cmmd == "quit") {
    		Utilities.saveChanges(model);
    		System.exit(1);
    	} else if (cmmd == "help") {
    		Utilities.informUser(getFactory().getHelp());
    	} else if (cmmd == "about") {
    		Utilities.informUser(getFactory().about());
    	} else {
    		Utilities.error("Unrecognized command: " + cmmd);
    	}
    }

	// sort of works
	class ViewHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.out.println("inside MVCApp's ViewHandler");
			String cmmd = e.getActionCommand();
			View panel = getFactory().makeView(cmmd);
			panel.setModel(model);
			ViewFrame vf = new ViewFrame(panel);
			vf.setVisible(true);
			vf.setTitle(cmmd);
			desktop.add(vf);
			try {
				vf.setSelected(true);
			} catch (java.beans.PropertyVetoException ex) {}
		}
	}

    class EditHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		String cmmd = e.getActionCommand();
    		if(cmmd == "redo"){
    			commandProcessor.redo();
    		}
    		else if (cmmd == "undo"){
    			commandProcessor.undo();
    		}
    		Command cmmdObject = getFactory().makeCommand(cmmd);
    		cmmdObject.setModel(model);
    		commandProcessor.execute(cmmdObject);
    	}
    }

    public static void run(AppFactory factory) {
    	try {
    		MVCApp app = new MVCApp(factory);
    		app.setSize(800,600);
			app.setTitle(factory.getTitle());
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setVisible(true);
    	} catch(Exception e) {
    		Utilities.error("" + e);
    	}
    }

	public static void main(String[] args) {
		System.out.println("Inside MVC app");
	}
	public static AppFactory getFactory() {
		return factory;
	}
	public void setFactory(AppFactory fact){
		MVCApp.factory=fact;
	}
	public static Model getModel(){
		return MVCApp.model;
	}
	public static void setModel(Model model) {
		MVCApp.model = model;
	}
}
