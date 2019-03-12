package client;

import java.io.IOException;

public interface IControllerConnection {
    void action(String action, String outMessage) throws IOException;
}
