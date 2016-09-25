/**
 * 
 */
package com.rayzr522.webserver;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Rayzr
 *
 */
public class StreamSplitter extends PrintStream {

    private PrintStream other;

    public StreamSplitter(PrintStream original, PrintStream other) {
	super(original);
	this.other = other;
    }

    /**
     * @param b
     * @throws IOException
     * @see java.io.FilterOutputStream#write(byte[])
     */
    public void write(byte[] b) throws IOException {
	super.write(b);
	other.write(b);
    }

    /**
     * 
     * @see java.io.PrintStream#flush()
     */
    public void flush() {
	super.flush();
	other.flush();
    }

    /**
     * 
     * @see java.io.PrintStream#close()
     */
    public void close() {
	super.close();
	other.close();
    }

    /**
     * @param b
     * @see java.io.PrintStream#write(int)
     */
    public void write(int b) {
	super.write(b);
	other.write(b);
    }

    /**
     * @param buf
     * @param off
     * @param len
     * @see java.io.PrintStream#write(byte[], int, int)
     */
    public void write(byte[] buf, int off, int len) {
	super.write(buf, off, len);
	other.write(buf, off, len);
    }

    /**
     * @param b
     * @see java.io.PrintStream#print(boolean)
     */
    public void print(boolean b) {
	super.print(b);
	other.print(b);
    }

    /**
     * @param c
     * @see java.io.PrintStream#print(char)
     */
    public void print(char c) {
	super.print(c);
	other.print(c);
    }

    /**
     * @param i
     * @see java.io.PrintStream#print(int)
     */
    public void print(int i) {
	super.print(i);
	other.print(i);
    }

    /**
     * @param l
     * @see java.io.PrintStream#print(long)
     */
    public void print(long l) {
	super.print(l);
	other.print(l);
    }

    /**
     * @param f
     * @see java.io.PrintStream#print(float)
     */
    public void print(float f) {
	super.print(f);
	other.print(f);
    }

    /**
     * @param d
     * @see java.io.PrintStream#print(double)
     */
    public void print(double d) {
	super.print(d);
	other.print(d);
    }

    /**
     * @param s
     * @see java.io.PrintStream#print(char[])
     */
    public void print(char[] s) {
	super.print(s);
	other.print(s);
    }

    /**
     * @param s
     * @see java.io.PrintStream#print(java.lang.String)
     */
    public void print(String s) {
	super.print(s);
	other.print(s);
    }

    /**
     * @param obj
     * @see java.io.PrintStream#print(java.lang.Object)
     */
    public void print(Object obj) {
	super.print(obj);
	other.print(obj);
    }

    /**
     * 
     * @see java.io.PrintStream#println()
     */
    public void println() {
	super.println();
	other.println();
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(boolean)
     */
    public void println(boolean x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(char)
     */
    public void println(char x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(int)
     */
    public void println(int x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(long)
     */
    public void println(long x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(float)
     */
    public void println(float x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(double)
     */
    public void println(double x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(char[])
     */
    public void println(char[] x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(java.lang.String)
     */
    public void println(String x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param x
     * @see java.io.PrintStream#println(java.lang.Object)
     */
    public void println(Object x) {
	super.println(x);
	other.println(x);
    }

    /**
     * @param csq
     * @return
     * @see java.io.PrintStream#append(java.lang.CharSequence)
     */
    public PrintStream append(CharSequence csq) {
	super.append(csq);
	return other.append(csq);
    }

    /**
     * @param csq
     * @param start
     * @param end
     * @return
     * @see java.io.PrintStream#append(java.lang.CharSequence, int, int)
     */
    public PrintStream append(CharSequence csq, int start, int end) {
	super.append(csq, start, end);
	return other.append(csq, start, end);
    }

    /**
     * @param c
     * @return
     * @see java.io.PrintStream#append(char)
     */
    public PrintStream append(char c) {
	super.append(c);
	return other.append(c);
    }

}