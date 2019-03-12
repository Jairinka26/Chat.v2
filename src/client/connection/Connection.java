package client.connection;

import client.IConnectionController;
import client.IControllerConnection;
import client.Variables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection implements IControllerConnection {
    private IConnectionController controller;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String inMessage;
    private boolean isConnected = false;

    public void setController(IConnectionController controller) {
        this.controller = controller;
    }

    public void createConnection(String outMessage) throws IOException {
        socket = new Socket(Variables.HOST, Variables.PORT);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        sendOutMessage(outMessage);
        isConnected = true;
        controller.isConnected();
        new Listener().start();
    }

    private void sendOutMessage(String message) {
        try {
            out.writeUTF(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(String outMessage) throws IOException {
        sendOutMessage(outMessage);
        isConnected=false;
        socket.close();
    }

    @Override
    public void action(String action, String outMessage) throws IOException {
        switch (action) {
            case Variables.LOGIN_ACTION:
                createConnection(outMessage);
                break;
            case Variables.SEND_ACTION:
                sendOutMessage(outMessage);
                break;
            case Variables.EXIT_ACTION:
              //  isConnected = false;
                disconnect(outMessage);
                break;
        }
    }

    private class Listener extends Thread {
        @Override
        public void run() {
            while (isConnected) {
                try {
                    if (in.available() > 0) {
                        inMessage = in.readUTF();
                        System.out.println(inMessage);
                        controller.action(Variables.RECEIVE_ACTION, inMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}