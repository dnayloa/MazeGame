package com.dnayloa.main;

import com.dnayloa.main.Game;

import javax.swing.*;
import java.awt.*;

public class Window {

    int width, height;
    String name;

    public Window(int width, int height, String name, Game game){
        JFrame frame = new JFrame(name);

        frame.setMinimumSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setPreferredSize(new Dimension(width,height));

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //GETTERS AND SETTERS
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
