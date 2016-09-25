
package com.rayzr522.webserver;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class TextField extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1076222345645773786L;

    private JTextField field;

    public TextField(String label) {

	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	add(new JLabel(label));
	add(field = new JTextField());

    }

    /**
     * @param offs
     * @param len
     * @return
     * @throws BadLocationException
     * @see javax.swing.text.JTextComponent#getText(int, int)
     */
    public String getText(int offs, int len) throws BadLocationException {
	return field.getText(offs, len);
    }

    /**
     * @return
     * @see javax.swing.text.JTextComponent#getText()
     */
    public String getText() {
	return field.getText();
    }

    /**
     * @param t
     * @see javax.swing.text.JTextComponent#setText(java.lang.String)
     */
    public void setText(String t) {
	field.setText(t);
    }

}
