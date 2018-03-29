package com.dnayloa.main;

import com.dnayloa.handlers.Handler;
import com.dnayloa.window.Pane;
import com.dnayloa.window.Window;

import java.awt.*;

public class Main {

    static Thread th = new Thread();

    public static void main(String[] args) {
        Window window = new Window(800,800, "Window");
        Handler handler = new Handler();
        Pane pane = new Pane(handler);
        pane.setBackground(Color.BLUE);
        window.add(pane);
        //pane.setActivateMadMode(true);

        while(true){
            pane.update();
            window.repaint();
            try{
                th.sleep(3);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
