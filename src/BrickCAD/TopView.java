package BrickCAD;
import java.awt.*;
import MVC.*;

@SuppressWarnings("serial")

public class TopView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	Graphics g;
	public TopView(String title) {
		super();
		this.title = title;
		System.out.println(brick);
		setPreferredSize(new Dimension(400, 400));
		brick.addObserver(this);
		setLayout(new BorderLayout());
	}
	@Override
	public void paintComponent (Graphics g) {
	  super.paintComponent(g);
	  g.setColor(Color.RED);
	  g.fillRect (20, 20, (int) brick.getWidth()*10, (int) brick.getLength()*10);
	}
}
