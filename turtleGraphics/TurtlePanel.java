package turtleGraphics;

import java.awt.*;
import javax.swing.*;
import mvc.*;

public class TurtlePanel extends AppPanel {
	private JButton turn;
	private JButton move;
	private JButton clear;
	private JButton pen;
	private JButton color;
	
	public TurtlePanel(AppFactory factory) {
		super(factory);
		TurtleView view = new TurtleView((Turtle)model);
		this.setLayout(new GridLayout(1, 2));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		turn = new JButton("Turn");
		turn.addActionListener(this);
		JPanel turnPanel = new JPanel();
		turnPanel.add(turn);
		buttonPanel.add(turnPanel);
		
		move = new JButton("Move");
		move.addActionListener(this);
		JPanel movePanel = new JPanel();
		movePanel.add(move);
		buttonPanel.add(movePanel);
		
		clear = new JButton("Clear");
		clear.addActionListener(this);
		JPanel clearPanel = new JPanel();
		clearPanel.add(clear);
		buttonPanel.add(clearPanel);
		
		pen = new JButton("Pen");
		pen.addActionListener(this);
		JPanel penPanel = new JPanel();
		penPanel.add(pen);
		buttonPanel.add(penPanel);
		
		color = new JButton("Color");
		color.addActionListener(this);
		JPanel colorPanel = new JPanel();
		colorPanel.add(color);
		buttonPanel.add(colorPanel);
		
		add(buttonPanel);
		add(view);
	}

	public static void main(String[] args) {
		AppFactory factory = new TurtleFactory();
		AppPanel panel = new TurtlePanel(factory);
		panel.display();
	}

}
