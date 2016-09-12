
package com.rayzr522.webserver;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1076222345645773786L;

	public TextField(String label) {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(new JLabel(label));
		add(new JTextField());

	}

}
