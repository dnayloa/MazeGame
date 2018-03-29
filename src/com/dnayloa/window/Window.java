package com.dnayloa.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    int width, height;
    String name;

    public Window(int width, int height, String name){
        this.width = width;
        this.height = height;
        this.name = name;
        setSize(new Dimension(width,height));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle(name);
        setVisible(true);
    }

    //GETTERS AND SETTERS

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
