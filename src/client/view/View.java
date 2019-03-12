package client.view;

import client.IControllerView;
import client.IViewController;

import javax.swing.*;
import java.io.IOException;


public class View implements ICallback, IControllerView {
    private boolean isConnected = false;
    private JFrame loginFrame;
    private IViewController controller;
    private ChatFrame chatFrame;

    public View(IViewController controller) {
        this.controller = controller;
        router();
    }

    private void router() {
        if (!isConnected) {
            loginFrame = new LoginFrame(this);
            loginFrame.setVisible(true);
        } else {
            loginFrame.setVisible(false);
            chatFrame = new ChatFrame(this);
            chatFrame.setVisible(true);
        }
    }

    @Override
    public void action(String action)  {
        action(action,"");
    }

    @Override
    public void action(String action, String data)  {
        System.out.println(action);
        try {
            controller.action(action,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void isConnected() {
        isConnected = true;
        router();
    }

    @Override
    public void receivingMessage(String message) {
        chatFrame.printInMessage(message);
    }
}
