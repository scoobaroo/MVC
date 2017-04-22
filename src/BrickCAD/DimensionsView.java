package BrickCAD;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;

import MVC.*;

@SuppressWarnings("serial")
public class DimensionsView extends View {
	Brick brick = (Brick) getModel();
	Graphics g;
	public DimensionsView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void paint (Graphics g) {
		  g.drawRect (20, 20, (int) brick.getWidth(), (int) brick.getHeight());    //can use either of the two//
		  g.fillRect (20, 20, (int) brick.getWidth(), (int) brick.getHeight());
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
