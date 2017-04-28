package BrickCAD;
import java.awt.*;
import java.util.Observable;
import javax.swing.*;

import MVC.*;@SuppressWarnings("serial")
public class DimensionsView extends View {
	Brick brick = (Brick) BrickCAD.getModel();
	AppFactory factory = MVCApp.getFactory();
	JLabel heightField;
	JLabel lengthField;
	JLabel widthField;
	public DimensionsView(String title) {
		super();
		this.title = title;
		System.out.println(brick);
		setSize(200,200);
		brick.addObserver(this);
        JPanel fieldsPanel = new JPanel();
        JLabel attributes = new JLabel("Brick Attributes");
        JLabel height = new JLabel("Height");
        JLabel width = new JLabel("Width");
        JLabel length = new JLabel("Length");
        heightField = new JLabel(String.valueOf(brick.getHeight()));
        widthField = new JLabel(String.valueOf(brick.getWidth()));
        lengthField = new JLabel(String.valueOf(brick.getLength()));
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(attributes);
        fieldsPanel.add(height);
        fieldsPanel.add(heightField);
        fieldsPanel.add(width);
        fieldsPanel.add(widthField);
        fieldsPanel.add(length);
        fieldsPanel.add(lengthField);        
        this.add(fieldsPanel, BorderLayout.PAGE_START);
	}
	@Override
	public void update(Observable o, Object arg) {
		heightField.setText(String.valueOf(brick.getHeight()));
		lengthField.setText(String.valueOf(brick.getLength()));
		widthField.setText(String.valueOf(brick.getWidth()));
	}
}
