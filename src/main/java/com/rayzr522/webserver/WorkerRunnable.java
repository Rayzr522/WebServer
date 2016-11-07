
package com.rayzr522.webserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class WorkerRunnable implements Runnable {

    static {

        try {
            String path = Server.class.getResource("/Test.png").getPath();
            FileInputStream stream = new FileInputStream(new File(path));
            stream.read(file = new byte[stream.available()]);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static byte[] file;

    protected Socket      clientSocket = null;

    public WorkerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {

            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();

            output.write(("HTTP/1.1 200 OK\nContent-Type: image/png\n\n").getBytes());
            output.write(file);
            output.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            // report exception somewhere.
            e.printStackTrace();
        }
    }
}