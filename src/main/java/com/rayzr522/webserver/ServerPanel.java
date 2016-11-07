/*
 * package com.rayzr522.webserver;
 * 
 * import java.awt.Component; import java.awt.Dimension; import java.io.File;
 * import java.io.FileNotFoundException;
 * import java.io.FileOutputStream; import java.io.IOException; import
 * java.io.OutputStream; import java.io.PrintStream;
 * import java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import javax.swing.JPanel; import javax.swing.SpringLayout;
 * 
 * public class ServerPanel extends JPanel {
 * 
 * 
 * private static final long serialVersionUID = -8060758851166489527L;
 * 
 * private static ServerPanel instance;
 * 
 * public static ServerPanel getInstance() { return instance; }
 * 
 * private TextArea console; private TextField portField;
 * 
 * private Server server; private int rows = 0;
 * 
 * @SuppressWarnings("resource") public ServerPanel() {
 * 
 * instance = this;
 * 
 * try { File log = new File("./web-server.log"); log.createNewFile();
 * ConsoleStream out = new ConsoleStream(System.out,
 * this, log); System.setOut(out);
 * 
 * System.setErr(new ErrorStream(System.err)); } catch (FileNotFoundException e)
 * { System.err.println(
 * "Could not find log file!"); e.printStackTrace(); } catch (IOException e) {
 * System.err.println(
 * "Failed to create log file!"); e.printStackTrace(); }
 * 
 * setLayout(new SpringLayout());
 * 
 * setMinimumSize(new Dimension(600, 400)); setPreferredSize(new Dimension(800,
 * 600)); setMaximumSize(new
 * Dimension(1280, 720));
 * 
 * add(console = new TextArea("Monospaced", 11)); add(portField = new
 * TextField("Port: ")); add(new Button("Start", e ->
 * start())); add(new Button("Stop", e -> stop())); add(new Button("Exit", e ->
 * exit()));
 * 
 * console.setEditable(false); portField.setText("8080");
 * 
 * SpringUtilities.makeCompactGrid(this, rows, 1, 5, 5, 5, 15);
 * 
 * // server = new Server(this, 8080);
 * 
 * }
 * 
 * @Override public Component add(Component comp) { rows++; return
 * super.add(comp); }
 * 
 * public synchronized void start() {
 * 
 * if (server.isStopped) { log("Starting..."); int port = 8080; try { port =
 * Integer.valueOf(portField.getText()); }
 * catch (NumberFormatException e) {
 * log("Invalid port number! Using default port (8080)"); }
 * server.setPort(port); new
 * Thread(server).start(); } else { log("Server already started!"); }
 * 
 * }
 * 
 * public void stop() {
 * 
 * if (server.isStopped) { log("Server is already stopped!"); return; }
 * 
 * log("Stopping...");
 * 
 * server.stop();
 * 
 * }
 * 
 * public void exit() {
 * 
 * log("Exiting...");
 * 
 * Thread.currentThread().interrupt(); System.exit(0);
 * 
 * }
 * 
 * public void _log(Object msg) {
 * 
 * console.println(msg); }
 * 
 * public void log(Object msg) { String txt = "[WebServer] " + msg;
 * System.out.println(txt); }
 * 
 * public static void print(Object msg) { instance.log(msg); }
 * 
 * public class ConsoleStream extends PrintStream {
 * 
 * private ServerPanel panel; private FileOutputStream fileStream;
 * 
 * public ConsoleStream(OutputStream out, ServerPanel panel, File file) throws
 * FileNotFoundException { super(out, true);
 * this.panel = panel; this.fileStream = new FileOutputStream(file); }
 * 
 * @Override public void print(String s) { super.print(s); panel._log(s); }
 * 
 * @Override public void println(String x) { super.println("[" + new
 * SimpleDateFormat("MM/dd/yy HH:mm:ss").format(new
 * Date()) + "] " + x); }
 * 
 * @Override public void write(byte[] b) throws IOException { super.write(b);
 * fileStream.write(b); }
 * 
 * @Override public void flush() { super.flush(); try { fileStream.flush(); }
 * catch (IOException e) {
 * e.printStackTrace(); } }
 * 
 * }
 * 
 * public class ErrorStream extends PrintStream {
 * 
 * public ErrorStream(PrintStream current) { super(current, true); }
 * 
 * @Override public void print(String x) { super.print(x);
 * System.out.println("[ERROR] " + x); }
 * 
 * }
 * 
 * }
 */