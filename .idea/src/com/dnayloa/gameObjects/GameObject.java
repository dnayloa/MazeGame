package com.dnayloa.gameObjects;
import javax.swing.*;
import java.awt.*;

/**
 * Created by dnayloa 28/03/2018
 */
public abstract class GameObject extends JComponent {
    private int x,y,width,height;
    private String ID, name;

    public GameObject(int x, int y, int width, int height, String ID, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ID = ID;
        this.name = name;
    }

    public abstract void update();

    public abstract void paintComponent(Graphics g);

    //GETTER AND SETTERS
    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
