package BrickCAD;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;

import MVC.*;

@SuppressWarnings("serial")
public class FrontView extends View{
	Graphics g;
	Brick brick = (Brick) getModel();
	public FrontView() {
		super();
	}
	@Override
	public void paint (Graphics g) {
		  g.drawRect (20, 20, (int) brick.getLength(), (int) brick.getHeight());    //can use either of the two//
		  g.fillRect (20, 20, (int) brick.getLength(), (int) brick.getHeight());
		  Color color = Color.red;
		  g.setColor(color );
		}
	public void update(Observable o, Object arg) {
		if(o.hasChanged()){
			paint(g);
		}
	}

}
