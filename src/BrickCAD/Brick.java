package BrickCAD;

import MVC.*;

@SuppressWarnings("serial")
public class Brick extends Model {
	private double height;
	private double width;
	private double length;
	public Brick(){
		this.height = 10.0;
		this.width = 20.0;
		this.length = 25.0;
		this.setFileName("brick");
		this.setUnsavedChanges(false);
	}
	public double getHeight(){
		return this.height;
	}
	public double getWidth(){
		return this.width;
	}
	public double getLength(){
		return this.length;
	}
	public void setHeight(double h){
		this.height=h;
	}
	public void setWidth(double w){
		this.width=w;
	}
	public void setLength(double l){
		this.length=l;
	}
	@Override
	public Memento makeMemento() {
		BrickMemento bm = new BrickMemento();
		bm.setLength(length);
		bm.setWidth(width);
		bm.setHeight(height);
		return bm;
	}
	public void accept(Memento m) {
		BrickMemento bm = (BrickMemento) m;
		this.length = bm.length;
		this.width = bm.width;
		this.height = bm.height;
	}

	public class BrickMemento implements Memento {
		public double height;
		public double length;
		public double width;
		public void setHeight(double height) {
			this.height = height;
		}
		public void setLength(double length) {
			this.length = length;
		}
		public void setWidth(double width) {
			this.width = width;
		}
	}
}
