package client;

import client.connection.Connection;
import client.conrtoller.Controller;
import client.view.View;

public class Client {
    public static void main(String[] args) {
        Connection connection = new Connection();
        Controller controller = new Controller(connection);
        connection.setController(controller);
        View view=new View(controller);
        controller.setView(view);


    }
}
