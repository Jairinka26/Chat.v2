package client.view;


import client.Variables;

import javax.swing.*;

public class LoginFrame extends JFrame {
    private JPanel loginPanel;
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField name;
    private ICallback callback;
    private static final int FRAME_WIDTH = 350;
    private static final int FRAME_HEIGHT = 200;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 30;
    private static final int SECOND_ROW = 50;
    private static final String LOGIN_BUTTON_NAME = "Login";
    private static final String EXIT_BUTTON_NAME = "Cancel";
    private static final String TITLE_NAME = "Chat v.2";
    private static final String LABEL_NAME = "Имя:";

     LoginFrame (ICallback callback) {
         this.callback =callback;
        prepare();
        listeners();
    }

    private void prepare() {
        setBounds(400, 150, FRAME_WIDTH, FRAME_HEIGHT);
        setTitle(TITLE_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        name = new JTextField();
        loginButton = new JButton(LOGIN_BUTTON_NAME);
        cancelButton = new JButton(EXIT_BUTTON_NAME);
        JLabel label = new JLabel(LABEL_NAME);

        label.setBounds(10, 10, 30, BUTTON_HEIGHT);
        name.setBounds(50, 10, 270, BUTTON_HEIGHT);
        loginButton.setBounds(10, SECOND_ROW, BUTTON_WIDTH, BUTTON_HEIGHT);
        cancelButton.setBounds(170, SECOND_ROW, BUTTON_WIDTH, BUTTON_HEIGHT);

        loginPanel.setLayout(null);
        loginPanel.setBounds(300, 260, FRAME_WIDTH, FRAME_HEIGHT);
        loginPanel.add(label);
        loginPanel.add(name);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);
        add(loginPanel);
    }

    private void listeners() {
        loginButton.addActionListener(l -> {
            callback.action(Variables.LOGIN_ACTION,name.getText());
        });

        cancelButton.addActionListener(l -> {
            callback.action(Variables.EXIT_ACTION);
        });
    }


}
