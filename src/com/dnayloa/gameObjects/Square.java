package com.dnayloa.gameObjects;

import java.awt.*;

/**
 * Created by drewnaylor on 05/04/2018.
 */
public class Square extends GameObject{

    public Square(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
