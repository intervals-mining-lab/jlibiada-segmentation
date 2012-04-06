package model;

import ui.WorkFrame;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 23.03.12
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private WorkFrame workFrame;
    private Algorithm algorithm;
    
    public Controller(Algorithm algorithm, WorkFrame workFrame){
        this.workFrame = workFrame;
        this.algorithm = algorithm;
    }

    public void run(){
        workFrame.setObserverToAlgorithm(algorithm);
        workFrame.setVisible(true);
    }
}
