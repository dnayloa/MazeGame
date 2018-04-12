package com.dnayloa.gameObjects;

import java.awt.*;

/**
 * Created by drewnaylor on 05/04/2018.
 */
public class Origin extends GameObject {

    public Origin(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x,y,width,height);
    }
}
