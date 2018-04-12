package com.dnayloa.gameObjects.collisionObjects;

import com.dnayloa.gameObjects.GameObject;

import java.awt.*;

/**
 * Class for the player object
 */
public class Player extends GameObject {

    Rectangle collider;

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
        //@TODO Add player movement and collision code
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x,y,width,height);
    }

    //GETTERS AND SETTERS

    public Rectangle getCollider() {
        return collider;
    }

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }
}
