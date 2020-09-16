package turtleGraphics;

import java.awt.Color;
import javax.swing.JColorChooser;
import mvc.*;

public class ColorCommand extends Command {
	public ColorCommand(Model model) {
		super(model);
	}

	public void execute() {
		 Turtle turtle = (Turtle) model;
		 Color newColor = JColorChooser.showDialog(null, "Choose a color", turtle.getColor());
		 turtle.setColor(newColor);
	}
	
}
