package com.dnayloa.gameObjects;

import java.awt.*;

public class Wall extends GameObject {

    Rectangle collider;

    public Wall(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        id = 1;
        name = "Wall";
        collider = new Rectangle(x,y,width,height);
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
    }
}
