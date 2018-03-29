package com.dnayloa.gameObjects;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        id = 9;
        name = "Player";
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x,y,width,height);
    }
}
