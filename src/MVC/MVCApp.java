package MVC;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MVCApp extends JFrame implements ActionListener {

	private JDesktopPane desktop;
	private AppFactory factory;
	private Model model;
	private CommandProcessor commandProcessor;

	public MVCApp(AppFactory factory) {

		this.factory = factory;
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
	public Model getModel(){
		return model;
	}
	public JDesktopPane getDesktop(){
		return this.desktop;
	}
	public AppFactory getFactory(){
		return factory;
	}
	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
        //Set up the lone menu.
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(editMenu);
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_W);
        menuBar.add(viewMenu);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_W);
        menuBar.add(helpMenu);
 
        JMenuItem menuItem = new JMenuItem("Help");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_H, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("help");
        menuItem.addActionListener((ActionListener) this);
        helpMenu.add(menuItem);
        
        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("new");
        menuItem.addActionListener((ActionListener) this);
        fileMenu.add(menuItem);
        
        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("save");
        menuItem.addActionListener((ActionListener) this);
        fileMenu.add(menuItem);
        
        menuItem = new JMenuItem("Open");
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("open");
        menuItem.addActionListener((ActionListener) this);
        fileMenu.add(menuItem);
                
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener((ActionListener) this);
        fileMenu.add(menuItem);
        menuItem = new JMenuItem("Undo");
        
        menuItem.setMnemonic(KeyEvent.VK_U);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_U, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("undo");
        menuItem.addActionListener((ActionListener) this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Redo");
        menuItem.setMnemonic(KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("redo");
        menuItem.addActionListener((ActionListener) this);
        editMenu.add(menuItem);

        menuItem = new JMenuItem("Edit Height");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_H, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editheight");
        menuItem.addActionListener((ActionListener) this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Edit Width");
        menuItem.setMnemonic(KeyEvent.VK_W);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_W, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editwidth");
        menuItem.addActionListener((ActionListener) this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Edit Length");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_L, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("editlength");
        menuItem.addActionListener((ActionListener) this);
        editMenu.add(menuItem);
        
        menuItem = new JMenuItem("Side View");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("sideview");
        menuItem.addActionListener((ActionListener) this);
        viewMenu.add(menuItem);
        
        menuItem = new JMenuItem("Top View");
        menuItem.setMnemonic(KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_T, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("topview");
        menuItem.addActionListener((ActionListener) this);
        viewMenu.add(menuItem);
       
        menuItem = new JMenuItem("Front View");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("frontview");
        menuItem.addActionListener((ActionListener) this);
        viewMenu.add(menuItem);
        
        menuItem = new JMenuItem("Dimensions View");
        menuItem.setMnemonic(KeyEvent.VK_D);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("dview");
        menuItem.addActionListener((ActionListener) this);
        viewMenu.add(menuItem);
        
        return menuBar;
    }

	public void actionPerformed(ActionEvent e){
    	String cmmd = e.getActionCommand();
    	if (cmmd == "save") {
    		Utilities.save(model);
    	} else if (cmmd == "SaveAs") {
    		Utilities.error("Sorry, not yet implemented");
    	} else if (cmmd == "open") {
    		Utilities.error("Sorry, not yet implemented");
    	} else if (cmmd == "new") {
    		Utilities.saveChanges(model);
    		model = factory.makeModel();
    	} else if (cmmd == "undo") {
    		commandProcessor.undo();
    	} else if (cmmd == "redo") {
    		commandProcessor.redo();
    	} else if (cmmd == "quit") {
    		Utilities.saveChanges(model);
    		System.exit(1);
    	} else if (cmmd == "help") {
    		Utilities.informUser(factory.getHelp());
    	} else if (cmmd == "about") {
    		Utilities.informUser(factory.about());
    	} else {
    		Utilities.error("Unrecognized command: " + cmmd);
    	}
    }

	// sort of works
	class ViewHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String cmmd = e.getActionCommand();
			View panel = factory.makeView(cmmd);
			panel.setModel(model);
			ViewFrame vf = new ViewFrame(panel);
			vf.setVisible(true);
			desktop.add(vf);
			try {
				vf.setSelected(true);
			} catch (java.beans.PropertyVetoException ex) {}
		}
	}

    class EditHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		String cmmd = e.getActionCommand();
    		Command cmmdObject = factory.makeCommand(cmmd);
    		cmmdObject.setModel(model);
    		commandProcessor.execute(cmmdObject);
        	// make a command and ask command processor to execute it
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

}
