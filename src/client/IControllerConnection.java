package client;

public interface IControllerConnection {
    void createConnection(String name);
    void sendMessage(String message);
    void disconnect();
}
