package com.simple.snakegame;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


@SuppressWarnings({ "unused", "serial" })
public class Frame1 extends JFrame {

	
	Frame1()
	{
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.add(new Panel1());
	     this.pack();
	     this.setVisible(true);
	     this.setLocationRelativeTo(null);
	     this.setResizable(false);
	}
}
