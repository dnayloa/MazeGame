package com.dnayloa.window;

import com.dnayloa.handlers.Handler;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pane extends JComponent {
    Handler handler;
    Random rnd = new Random();
    Color color = Color.lightGray;
    int colorCounter = 0;
    boolean activateMadMode = false;

    public Pane(Handler handler){
        this.handler = handler;
    }

    public void update(){
        if(activateMadMode){
            madMode();
        }
    }

    public void madMode(){
        if(colorCounter > 40){
            colorChange();
            colorCounter = 0;
        }else{
            colorCounter++;
        }
    }

    public void colorChange(){
        this.setColor(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
    }


    public void paintComponent(Graphics g){
        g.setColor(color);
        g.fillRect(0,0,800,790);
    }

    //GETTERS AND SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getColorCounter() {
        return colorCounter;
    }

    public void setColorCounter(int colorCounter) {
        this.colorCounter = colorCounter;
    }

    public boolean isActivateMadMode() {
        return activateMadMode;
    }

    public void setActivateMadMode(boolean activateMadMode) {
        this.activateMadMode = activateMadMode;
    }
}
