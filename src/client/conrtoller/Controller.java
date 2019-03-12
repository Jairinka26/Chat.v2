package client.conrtoller;

import client.*;

import java.io.IOException;

public class Controller implements IViewController, IConnectionController {
    private IControllerConnection connection;
    private IControllerView view;
    private boolean isConnected = false;

    public Controller(IControllerConnection connection) {
        this.connection = connection;
    }

    public void setView(IControllerView view) {
        this.view = view;
    }

    @Override
    public void action(String action, String message) {
        switch (action) {
            case Variables.LOGIN_ACTION:
                try {
                    connection.action(action, buildOutMessage(action, message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case Variables.SEND_ACTION:
                try {
                    connection.action(action, buildOutMessage(action, message));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case Variables.EXIT_ACTION:
                if (isConnected) {
                    try {
                        connection.action(action, buildOutMessage(action, message));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.exit(0);
                break;
            case Variables.RECEIVE_ACTION:
                view.receivingMessage(message);
                break;
            default:
                System.out.println("Unsupported command: " + action);

        }
    }

    @Override
    public void isConnected() {
        isConnected = true;
        view.isConnected();
    }

    private String buildOutMessage(String action, String message) {
        return action + Variables.DELIMITER + message;
    }
}

