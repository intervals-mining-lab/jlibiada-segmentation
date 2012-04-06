package model;

import ui.WorkFrame;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.10.2011
 * Time: 17:58:44
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Algorithm(), new WorkFrame());
        controller.run();
    }
}
