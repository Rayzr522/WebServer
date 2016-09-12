
package com.rayzr522.webserver;

import java.awt.Font;
import java.io.File;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1830001230107979394L;

	private ServerPanel			panel;

	public Main() {

		init();

		raw("-----------------------------------");
		raw("* Welcome to WebServer v0.1!      *");
		raw("* Made by Rayzr522                *");
		raw("* This is a test webserver        *");
		raw("-----------------------------------");

	}

	private void init() {

		panel = new ServerPanel();

		add(panel);
		pack();

		setMinimumSize(panel.getMinimumSize());
		setPreferredSize(panel.getPreferredSize());
		setMaximumSize(panel.getMaximumSize());

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void start() {
		panel.start();
	}

	public static void main(String[] args) {

		raw("Initializing...");

		Main main = new Main();
		main.start();

	}

	public static void raw(Object msg) {
		System.out.println(msg);
	}

}
