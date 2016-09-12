
package com.rayzr522.webserver;

import java.awt.Font;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {

	public TextArea(String font, int size) {

		setFont(new Font(font, 0, size));

	}

}
