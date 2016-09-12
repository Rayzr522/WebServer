
package com.rayzr522.webserver;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ServerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8060758851166489527L;

	private static ServerPanel	instance;
	private static PrintStream	out;
	private static PrintStream	oldOut;

	public static ServerPanel getInstance() {
		return instance;
	}

	private TextArea	console;
	private int			rows	= 0;

	public ServerPanel() {

		instance = this;

		try {
			File file = new File("./latest.log");
			out = new PrintStream(file);
			oldOut = System.out;
			System.setOut(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		setLayout(new SpringLayout());

		setMinimumSize(new Dimension(600, 400));
		setPreferredSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(1280, 720));

		add(console = new TextArea("Monospaced", 11));
		add(new Button("Stop", e -> stop()));

		console.setEditable(false);

		SpringUtilities.makeCompactGrid(this, rows, 1, 5, 5, 5, 15);

	}

	@Override
	public Component add(Component comp) {
		rows++;
		return super.add(comp);
	}

	public void start() {

		log("Starting...");

	}

	public void stop() {

		log("Stopping...");
		out.close();
		System.exit(0);

	}

	public void log(Object msg) {
		String txt = "[" + new Date().toString() + "] [WebServer] " + msg;
		console.setText(console.getText() + txt + "\n");
		System.out.println(txt);
		oldOut.println(txt);
	}

}
