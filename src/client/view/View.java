package client.view;

import client.ILoginFrameController;

public class View {
    public View(ILoginFrameController controller) {
        new LoginFrame().start(controller);
    }
}
