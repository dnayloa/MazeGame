package com.dnayloa.handlers;

import com.dnayloa.gameObjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Handler extends ArrayList<GameObject> {

    public Handler(){
        new ArrayList<GameObject>();
    }

    public void update(){
        Iterator<GameObject> it = this.iterator();
        while (it.hasNext()){
            GameObject temp = it.next();
            temp.update();
        }
    }

    public void paintComponent(Graphics g){
        Iterator<GameObject> it = this.iterator();
        while (it.hasNext()){
            GameObject temp = it.next();
            temp.paintComponent(g);
        }
    }
}
