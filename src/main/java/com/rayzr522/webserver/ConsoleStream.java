/**
 * 
 */
package com.rayzr522.webserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

/**
 * @author Rayzr
 *
 */
public class ConsoleStream extends PrintStream {

    private Consumer<String> code;
    private FileOutputStream fileStream;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    public ConsoleStream(OutputStream out, Consumer<String> code, File file) throws FileNotFoundException {
	super(out, true);
	this.code = code;
	this.fileStream = new FileOutputStream(file);
    }

    @Override
    public void print(String s) {
	super.print(s);
	code.accept(s);

	try {
	    fileStream.write(s.getBytes());
	    if (s.indexOf("\n") >= 0) {
		fileStream.flush();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public void println(String x) {
	print("[" + dateFormat.format(new Date()) + "] " + x + "\n");
    }

    @Override
    public void write(byte[] b) throws IOException {
	super.write(b);
	fileStream.write(b);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.PrintStream#close()
     */
    @Override
    public void close() {
	super.close();
	try {
	    fileStream.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
