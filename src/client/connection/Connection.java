package client.connection;

import client.IConnectionController;
import client.IControllerConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection  implements IControllerConnection {
    IConnectionController controller;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 7777;
    private DataOutputStream out;
    private InputStreamReader in;

    public Connection() throws IOException {
        Socket socket = new Socket(HOST,PORT);
        out = new DataOutputStream(socket.getOutputStream());
        in = new InputStreamReader(socket.getInputStream());
    }

    public void setController  (IConnectionController controller){
        this.controller = controller;
    }
    @Override
    public void createConnection(String name) {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void disconnect() {

    }

    void listener(){

    }
}
