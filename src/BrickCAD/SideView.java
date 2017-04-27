package BrickCAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Observable;

import MVC.*;

@SuppressWarnings("serial")
public class SideView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	Graphics g;
	public SideView(String title) {
		super();
		this.title=title;
		System.out.println(brick);
		setPreferredSize(new Dimension(400, 400));
		brick.addObserver(this);
		setLayout(new BorderLayout());
	}
	public void paintComponent (Graphics g) {
		  super.paintComponent(g);
		  g.setColor(Color.RED);//can use either of the two//
		  g.fillRect (20, 20, (int) brick.getWidth()*10, (int) brick.getHeight()*10);
		}
}
