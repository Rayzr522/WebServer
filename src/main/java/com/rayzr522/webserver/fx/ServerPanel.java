/**
 * 
 */
package com.rayzr522.webserver.fx;

import java.io.File;
import java.util.Arrays;

import com.rayzr522.webserver.ConsoleStream;
import com.rayzr522.webserver.Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Rayzr
 *
 */
public class ServerPanel extends Parent {

    @FXML
    TextField consoleInput;
    @FXML
    TextArea console;

    private Server server;
    private Main main;

    private ConsoleStream out;

    public ServerPanel() {

	init();

    }

    private void init() {

	try {
	    out = new ConsoleStream(System.out, s -> {
		console.setText(console.getText() + s);
	    }, new File("latest.log"));
	    System.setOut(out);
	} catch (Exception e) {
	    System.out.println("Failed to redirect console output!");
	    e.printStackTrace();
	    System.exit(1);
	}

	server = new Server(this, 8080);

    }

    /**
     * @return the server
     */
    public Server getServer() {
	return server;
    }

    /**
     * @return the main program
     */
    public Main getMain() {
	return main;
    }

    @FXML
    public void onConsoleCommand(KeyEvent event) {
	if (event.getCode() == KeyCode.ENTER) {
	    String command = consoleInput.getText();
	    if (!command.trim().equals("")) {
		System.out.println(command);

	    }
	    consoleInput.setText("");
	}
    }

    @FXML
    public void onStart(ActionEvent event) {

	if (!server.isStopped()) {
	    log("The server is already running!", "Please stop it first.");
	} else {
	    log("Starting server...");
	    new Thread(server).start();
	}

    }

    @FXML
    public void onStop(ActionEvent event) {
	if (server.isStopped()) {
	    log("The server is already stopped.");
	} else {
	    server.stop();
	    log("Server stopped.");
	}
    }

    private void log(String... strings) {
	Arrays.stream(strings).forEach(s -> System.out.println(s));
    }

    public void exit() {
	System.out.println("Exiting...");
	out.close();
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	System.exit(0);
    }

}
