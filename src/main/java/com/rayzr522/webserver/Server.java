
package com.rayzr522.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.rayzr522.webserver.fx.ServerPanel;

public class Server implements Runnable {

    protected ServerPanel  panel;
    protected int          port          = 8080;
    protected ServerSocket serverSocket  = null;
    protected boolean      isStopped     = true;
    protected Thread       runningThread = null;

    public Server(ServerPanel panel, int port) {
        this.panel = panel;
        this.port = port;
    }

    @SuppressWarnings("resource")
    public void run() {

        synchronized (this) {
            runningThread = Thread.currentThread();
        }
        openServerSocket();

        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            new Thread(new WorkerRunnable(clientSocket)).start();
        }
        log("Socket closed");
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }

    public synchronized void stop() {
        isStopped = true;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(port);
            isStopped = false;
            log("Server socket opened on port " + port);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + port, e);
        }
    }

    private void log(Object msg) {
        System.out.println("[Server] " + msg);
    }

    public void setPort(int port) {
        if (!isStopped) {
            System.err.println("Attempted to change port while server was running!");
        } else {
            this.port = port;
        }
    }

}