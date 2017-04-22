package BrickCAD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Observable;

import javax.swing.JInternalFrame;

import MVC.*;

@SuppressWarnings("serial")

public class TopView extends View {
	Brick brick = (Brick) getModel();
	Graphics g;
	public TopView() {
		super();
		brick.addObserver(this);
		setLayout(new BorderLayout());
	}
	@Override
	public void paint (Graphics g) {
	  g.drawRect (20, 20, (int) brick.getWidth(), (int) brick.getLength());    //can use either of the two//
	  g.fillRect (20, 20, (int) brick.getWidth(), (int) brick.getLength());
	  Color color = Color.red;
	  g.setColor(color );
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o.hasChanged()){
			paint(g);
		}
	}
}
