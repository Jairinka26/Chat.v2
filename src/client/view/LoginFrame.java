package client.view;

import client.ILoginFrameController;

import javax.swing.*;

public class LoginFrame extends JFrame {
    private JPanel loginPanel;
    JButton loginButton;
    JButton cancelButton;
    JTextField name;
    private static final int FRAME_WIDTH = 350;
    private static final int FRAME_HEIGHT = 200;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 30;
    private static final int SECOND_ROW = 50;
    private static final String BUTTON_LOGIN_NAME = "Login";
    private static final String BUTTON_EXIT_NAME = "Cancel";
    private static final String TITLE_NAME = "Chat v.2";
    private static final String LABEL_NAME = "Имя:";


    public void start(ILoginFrameController controller) {
        prepare();
        setVisible(true);
        listeners(controller);
    }

    private void prepare() {
        setBounds(400, 150, FRAME_WIDTH, FRAME_HEIGHT);
        setTitle(TITLE_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        name = new JTextField();
        loginButton = new JButton(BUTTON_LOGIN_NAME);
        cancelButton = new JButton(BUTTON_EXIT_NAME);
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

    void listeners(ILoginFrameController controller) {
        loginButton.addActionListener(l -> {
            controller.login(name.getText());

        });
    }


}
