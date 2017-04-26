package BrickCAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Observable;

import MVC.*;

@SuppressWarnings("serial")
public class FrontView extends View{
	Graphics g;
	Brick brick = (Brick) BrickCAD.getModel();
	public FrontView(String title) {
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
     	  g.setColor(Color.BLUE);
		  g.drawRect (20, 20, (int) brick.getLength()*10, (int) brick.getHeight()*10);    //can use either of the two//
		  g.setColor(Color.RED);
		  g.fillRect (20, 20, (int) brick.getLength()*10, (int) brick.getHeight()*10);
	}
	public void update(Observable o, Object arg) {
			repaint();
	}
}
