package MVC;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ViewFrame extends JInternalFrame implements Observer {
	private static int openFrameCount = 0;
	public ViewFrame(View view) {
        super(view.getTitle(),
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        setContentPane(view);
        setSize(600, 600);
        setLocation(30*openFrameCount, 30*openFrameCount);
        pack();
	}
	public ViewFrame() {

	}
	@Override
	public void update(Observable o, Object arg) {

	}
}