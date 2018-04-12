package com.dnayloa.gameObjects.collisionObjects;

import com.dnayloa.gameObjects.GameObject;

import java.awt.*;

/**
 * Class of the wall objects in the maze
 */

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

    //GETTER AND SETTERS


    public Rectangle getCollider() {
        return collider;
    }

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }
}
