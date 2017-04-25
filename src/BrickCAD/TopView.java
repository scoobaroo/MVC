package BrickCAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Observable;

import MVC.*;

@SuppressWarnings("serial")

public class TopView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	Graphics g;
	public TopView() {
		super();
		System.out.println(brick);
		setPreferredSize(new Dimension(400, 400));
		brick.addObserver(this);
		setLayout(new BorderLayout());
	}
	@Override
	public void paintComponent (Graphics g) {
	  super.paintComponent(g);
	  g.setColor(Color.BLUE);
	  g.drawRect (20, 20, (int) brick.getWidth()*10, (int) brick.getLength()*10);    //can use either of the two//
	  g.setColor(Color.RED);
	  g.fillRect (20, 20, (int) brick.getWidth()*10, (int) brick.getLength()*10);
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o.hasChanged()){
			paintComponent(g);
		}
	}
}
