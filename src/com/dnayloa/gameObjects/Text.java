package com.dnayloa.gameObjects;

import java.awt.*;

/**
 * Created by drewnaylor on 04/04/2018.
 */
public class Text extends GameObject{

    private String text;

    public Text(int x, int y, String text){
        this.x = x;
        this.y = y;
        this.text = text;
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.drawString(text,x,y);
    }

    //GETTERS AND SETTERS

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
