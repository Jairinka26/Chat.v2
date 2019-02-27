package client.conrtoller;

import client.IChatFrameController;
import client.IConnectionController;
import client.IControllerConnection;
import client.ILoginFrameController;

public class Controller implements ILoginFrameController, IChatFrameController, IConnectionController {
    IControllerConnection connection;

    public Controller(IControllerConnection connection) {
        this.connection = connection;
    }

    @Override
    public void login(String name) {
        System.out.println("Login by " + name);

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void exit() {

    }

    @Override
    public void receiveMessage(String message) {

    }
}
